package org.vidyq.business;

import org.vidyq.client.ClientFieldCondition;
import org.vidyq.client.enums.ComparisonEnum;

public class FieldCondition {

	private ComparisonEnum comparison;
	private Object value;
	private QueryField field;
	
	public FieldCondition(ComparisonEnum igualdad, Object valor, QueryField campo) {
		super();
		this.comparison = igualdad;
		this.value = valor;
		this.field = campo;
	}
	
	public FieldCondition(ClientFieldCondition condition){
		this.field = new QueryField(condition.getField());
		this.value = condition.getValue();
		this.comparison = condition.getComparison();
	}

	public ComparisonEnum getComparison() {
		return comparison;
	}

	public void setComparison(ComparisonEnum comparison) {
		this.comparison = comparison;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public QueryField getField() {
		return field;
	}

	public void setField(QueryField field) {
		this.field = field;
	}

	
}
