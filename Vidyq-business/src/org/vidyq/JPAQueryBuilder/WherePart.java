package org.vidyq.JPAQueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class WherePart {

	private String alias;
	private String campo;
	private String operador;
	private String igualdad;
	private Object valor;
	
	private List<WherePart> subWhere = new ArrayList<WherePart>();
	
	public WherePart(){
	}
	public WherePart(String alias, String campo, String operador,
			String igualdad, Object valor) {
		super();
		this.alias = alias;
		this.campo = campo;
		this.operador = operador;
		this.igualdad = igualdad;
		this.valor = valor;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public String getIgualdad() {
		return igualdad;
	}
	public void setIgualdad(String igualdad) {
		this.igualdad = igualdad;
	}
	public Object getValor() {
		return valor;
	}
	public void setValor(Object valor) {
		this.valor = valor;
	}
	public List<WherePart> getSubWhere() {
		return subWhere;
	}
	public void setSubWhere(List<WherePart> subWhere) {
		this.subWhere = subWhere;
	}
	
}
