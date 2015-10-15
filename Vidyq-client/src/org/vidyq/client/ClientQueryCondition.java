package org.vidyq.client;

import java.util.ArrayList;
import java.util.List;

import org.vidyq.client.enums.OperatorEnum;

public class ClientQueryCondition {

	private ClientFieldCondition fieldCondition;
	private OperatorEnum operator;
	private List<ClientQueryCondition> conditions = new ArrayList<ClientQueryCondition>();

	public ClientQueryCondition(ClientFieldCondition campo, OperatorEnum operador) {
		super();
		this.fieldCondition = campo;
		this.operator = operador;
	}

	public ClientQueryCondition(List<ClientQueryCondition> condiciones,
			OperatorEnum operador) {
		super();
		this.conditions = condiciones;
		this.operator = operador;
	}

	public ClientQueryCondition() {
	}

	public ClientFieldCondition getFieldCondition() {
		return fieldCondition;
	}

	public void setFieldCondition(ClientFieldCondition fieldCondition) {
		this.fieldCondition = fieldCondition;
	}

	public OperatorEnum getOperator() {
		return operator;
	}

	public void setOperator(OperatorEnum operator) {
		this.operator = operator;
	}

	public List<ClientQueryCondition> getConditions() {
		return conditions;
	}

	public void setConditions(List<ClientQueryCondition> conditions) {
		this.conditions = conditions;
	}

}
