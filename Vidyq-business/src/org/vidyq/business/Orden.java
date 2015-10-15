package org.vidyq.business;

import org.vidyq.client.ClientQueryOrder;
import org.vidyq.client.enums.OrderEnum;

public class Orden {

	private OrderEnum order;
	private QueryField field;
	
	public Orden(OrderEnum orden, QueryField campo) {
		super();
		this.order = orden;
		this.field = campo;
	}
	
	public Orden(ClientQueryOrder order){
		this.order = order.getOrden();
		this.field = new QueryField(order.getCampo());
	}

	public OrderEnum getOrder() {
		return order;
	}

	public void setOrder(OrderEnum order) {
		this.order = order;
	}

	public QueryField getField() {
		return field;
	}

	public void setField(QueryField field) {
		this.field = field;
	}
	
	
}
