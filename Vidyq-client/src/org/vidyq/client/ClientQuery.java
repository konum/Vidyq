package org.vidyq.client;


import java.util.ArrayList;
import java.util.List;

import org.vidyq.client.enums.OperatorEnum;

public class ClientQuery {

	private List<ClientQueryCondition> conditions = new ArrayList<ClientQueryCondition>();
	private List<ClientQueryOrder> order = new ArrayList<ClientQueryOrder>();

	public ClientQuery and(ClientFieldCondition campo) {
		ClientQueryCondition condicion = new ClientQueryCondition(campo, OperatorEnum.AND);
		this.getConditions().add(condicion);
		return this;
	}

	public ClientQuery or(ClientFieldCondition campo) {
		ClientQueryCondition condicion = new ClientQueryCondition(campo, OperatorEnum.OR);
		this.getConditions().add(condicion);
		return this;
	}

	public ClientQuery orderBy(ClientQueryOrder orden) {
		this.getOrder().add(orden);
		return this;
	}

	public List<ClientQueryCondition> getConditions() {
		return conditions;
	}

	public void setConditions(List<ClientQueryCondition> conditions) {
		this.conditions = conditions;
	}

	public List<ClientQueryOrder> getOrder() {
		return order;
	}

	public void setOrder(List<ClientQueryOrder> order) {
		this.order = order;
	}

	
}
