package org.vidyq.client;


import org.vidyq.client.enums.OrderEnum;

public class ClientQueryOrder {

	private OrderEnum orden;
	private ClientQueryField campo;
	
	public ClientQueryOrder(OrderEnum orden, ClientQueryField campo) {
		super();
		this.orden = orden;
		this.campo = campo;
	}
	public OrderEnum getOrden() {
		return orden;
	}
	public void setOrden(OrderEnum orden) {
		this.orden = orden;
	}
	public ClientQueryField getCampo() {
		return campo;
	}
	public void setCampo(ClientQueryField campo) {
		this.campo = campo;
	}
}
