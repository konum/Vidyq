package org.vidyq.JPAQueryBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.persistence.Query;

import org.vidyq.business.Condition;
import org.vidyq.business.ModelQuery;
import org.vidyq.business.Orden;
import org.vidyq.client.enums.ComparisonEnum;
import org.vidyq.client.enums.OperatorEnum;

public class QueryBuilder {

	private String entity;
	private SelectFromPart selectFrom;
	private List<SelectFromPart> joinChild = new ArrayList<SelectFromPart>();
	private List<WherePart> selectWhat = new ArrayList<WherePart>();
	private StringBuilder order = new StringBuilder();

	public QueryBuilder(ModelQuery consulta) {
		entity = consulta.getEntidad().getSimpleName();
		selectFrom = new SelectFromPart();
		selectFrom.setFrom(entity + " a ");
		selectFrom.setSelect(" a ");
		Map<String, String> aliasEntidades = new HashMap<String, String>();
		aliasEntidades.put(entity, "a");
		Character aliasCount = 'b';
		for (Condition condicion : consulta.getConditions()) {
			String alias = aliasEntidades.get(condicion.getFieldCondition()
					.getField().getEntidad());
			if (alias == null) {
				SelectFromPart fromChild = new SelectFromPart();
				fromChild.setFrom(condicion.getFieldCondition().getField()
						.getEntidad().replace("", "")
						+ " " + aliasCount + " ");
				fromChild.setSelect(aliasCount.toString());
				alias = aliasCount.toString();
				aliasCount++;
				this.joinChild.add(fromChild);
			}
			this.selectWhat.add(getWherePart(alias, condicion));
		}
		if (!consulta.getOrder().isEmpty()) {
			boolean first = true;
			for (Orden orden : consulta.getOrder()) {
				if (!first)
					order.append(" , ");
				first = false;
				order.append(
						aliasEntidades.get(orden.getField().getEntidad()
								.replace("", ""))).append(".")
						.append(orden.getField().getNombre()).append(" ")
						.append(orden.getOrder().toString());
			}
		}
	}

	/**
	 * Construye el where de forma recursiva
	 * 
	 * @param alias
	 * @param condicion
	 * @return
	 */
	private WherePart getWherePart(String alias, Condition condicion) {
		WherePart where = new WherePart(alias, condicion.getFieldCondition()
				.getField().getNombre(), getOperador(condicion.getOperator()),
				getIgualdad(condicion.getFieldCondition().getComparison()),
				condicion.getFieldCondition().getValue());
		if (!condicion.getSubconditions().isEmpty()) {
			for (Condition subCondicion : condicion.getSubconditions()) {
				where.getSubWhere().add(getWherePart(alias, subCondicion));
			}
		}
		return where;
	}

	private String buildWhere(List<WherePart> whereList) {
		StringBuilder where = new StringBuilder();
		boolean firstExpresion = true;
		for (WherePart wherePart : whereList) {
			where.append(firstExpresion ? "" : wherePart.getOperador()).append(
					" ");
			firstExpresion = false;
			if (wherePart.getSubWhere().isEmpty()) {
				where.append(wherePart.getAlias())
						.append(".")
						.append(wherePart.getCampo())
						.append(wherePart.getIgualdad())
						.append(":".concat(wherePart.getAlias().concat(
								wherePart.getCampo()))).append(" ");
			} else {
				where.append(" (").append(buildWhere(wherePart.getSubWhere()))
						.append(") ");
			}
		}
		return where.toString();
	}

	/**
	 * Obtiene un string de query parametrizada para JPA. Para setear los parametros debe llamarse a la funcion setConitions(Query) 
	 * con el objeto query creado en el DAO.	 * 
	 * @return Stgring para crear una {@link Query}.
	 */
	public String getJPAQuery() {
		StringBuilder query = new StringBuilder("SELECT ");
		query.append(selectFrom.getSelect());
		for (SelectFromPart selectFromPart : joinChild) {
			query.append(", ").append(selectFromPart.getSelect());
		}
		query.append(" FROM ").append(selectFrom.getFrom());
		for (SelectFromPart selectFromPart : joinChild) {
			query.append(", ").append(selectFromPart.getFrom());
		}
		query.append(" WHERE ");
		query.append(buildWhere(this.selectWhat));
		if (order.length() > 1) {
			query.append(" ORDER BY ");
			query.append(" ").append(order.toString());
		}
		return query.toString();
	}

	/**
	 * Setea los parametros en el objeto query en concordancia con la query obtenida con el metodo
	 * getJPAQuery()
	 * @param query
	 */
	public void setConditions(Query query) {
		for (WherePart where : selectWhat) {
			query.setParameter(where.getAlias().concat(where.getCampo()),
					where.getValor());
		}
	}

	private String getOperador(OperatorEnum operador) {
		switch (operador) {
		case AND:
			return "AND";
		case OR:
			return "OR";
		}
		return "AND";
	}

	private String getIgualdad(ComparisonEnum igualdad) {
		switch (igualdad) {
		case EQ:
			return "=";
		case NEQ:
			return "<>";
		case GET:
			return ">=";
		case GT:
			return ">";
		case LT:
			return "<";
		case LET:
			return "<=";
		case LIKE:
			return "LIKE";
		}
		return "=";
	}
}
