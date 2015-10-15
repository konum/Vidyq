package org.vidyq.business;

import java.util.ArrayList;
import java.util.List;

import org.vidyq.client.ClientQuery;
import org.vidyq.client.ClientQueryCondition;
import org.vidyq.client.ClientQueryOrder;
import org.vidyq.client.enums.OperatorEnum;


@SuppressWarnings("rawtypes")
public class ModelQuery {
	

	private List<Condition> conditions = new ArrayList<Condition>();
	private List<Orden> order = new ArrayList<Orden>();
	private Class entity;
	
	public ModelQuery(Class entidad) {
		super();
		this.entity = entidad;
	}
	
	public ModelQuery(ClientQuery clientQuery,Class entidad) {
		super();
		for (ClientQueryOrder order : clientQuery.getOrder()) {
			this.order.add(new Orden(order));
		}
		for (ClientQueryCondition condition : clientQuery.getConditions()) {
			this.conditions.add(new Condition(condition));
		}
		this.entity = entidad;
	}

	public Class getEntidad(){
		return this.entity;
	}

	public ModelQuery and(FieldCondition campo) {
		Condition condicion = new Condition(campo, OperatorEnum.AND);
		this.getConditions().add(condicion);
		return this;
	}

	public ModelQuery or(FieldCondition campo) {
		Condition condicion = new Condition(campo, OperatorEnum.OR);
		this.getConditions().add(condicion);
		return this;
	}

	public ModelQuery orderBy(Orden order) {
		this.getOrder().add(order);
		return this;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public List<Orden> getOrder() {
		return order;
	}

	public void setOrder(List<Orden> order) {
		this.order = order;
	}

	public Class getEntity() {
		return entity;
	}

	public void setEntity(Class entity) {
		this.entity = entity;
	}
	
	
}
