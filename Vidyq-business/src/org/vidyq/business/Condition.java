package org.vidyq.business;

import java.util.ArrayList;
import java.util.List;

import org.vidyq.client.ClientQueryCondition;
import org.vidyq.client.enums.OperatorEnum;


public class Condition {

	private FieldCondition fieldCondition;
	private OperatorEnum operator;
	private List<Condition> subconditions = new ArrayList<Condition>();

	public Condition(FieldCondition campo, OperatorEnum operador) {
		super();
		this.fieldCondition = campo;
		this.operator = operador;
	}
	
	public Condition(List<Condition> condiciones, OperatorEnum operador) {
		super();
		this.subconditions = condiciones;
		this.operator = operador;
	}

	public Condition(ClientQueryCondition condicion){
		this.fieldCondition = new FieldCondition(condicion.getFieldCondition());
		this.operator = condicion.getOperator();
		//TODO: Recursive querys
	}
	public Condition(){
	}

	public FieldCondition getFieldCondition() {
		return fieldCondition;
	}

	public void setFieldCondition(FieldCondition fieldCondition) {
		this.fieldCondition = fieldCondition;
	}

	public OperatorEnum getOperator() {
		return operator;
	}

	public void setOperator(OperatorEnum operator) {
		this.operator = operator;
	}

	public List<Condition> getSubconditions() {
		return subconditions;
	}

	public void setSubconditions(List<Condition> subconditions) {
		this.subconditions = subconditions;
	}
	
}

	