package org.vidyq.client;


import org.vidyq.client.enums.ComparisonEnum;

public class ClientFieldCondition {

	private ComparisonEnum comparison;
	private Object value;
	private ClientQueryField field;
	
	public ClientFieldCondition(ComparisonEnum igualdad, Object valor, ClientQueryField campo) {
		super();
		this.setComparison(igualdad);
		this.value = valor;
		this.field = campo;
	}


	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public ClientQueryField getField() {
		return field;
	}

	public void setField(ClientQueryField field) {
		this.field = field;
	}


	public ComparisonEnum getComparison() {
		return comparison;
	}


	public void setComparison(ComparisonEnum comparison) {
		this.comparison = comparison;
	}
	
	
}
