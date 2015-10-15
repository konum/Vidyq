package org.vidyq.business;

import org.vidyq.client.ClientQueryField;
import org.vidyq.client.enums.ComparisonEnum;

public class QueryField {
	
	private String fieldName;
	private String entity;
	
	public QueryField(String entidad, String nombre) {
		super();
		this.entity = entidad;
		this.fieldName = nombre;
	}
	
	
	public QueryField(ClientQueryField campo){
		this.entity = campo.getEntity().replace("DTO", "");
		this.fieldName = campo.getFieldName();
	}
	
	public FieldCondition eq(Object valor){
		return new FieldCondition(ComparisonEnum.EQ, valor, this); 
	}
	
	public FieldCondition neq(Object valor){
		return new FieldCondition(ComparisonEnum.NEQ, valor, this); 
	}
	
	public FieldCondition mayorque(Object valor){
		return new FieldCondition(ComparisonEnum.GT, valor, this); 
	}
	
	public FieldCondition mayorIgualque(Object valor){
		return new FieldCondition(ComparisonEnum.GET, valor, this); 
	}
	
	public FieldCondition menorque(Object valor){
		return new FieldCondition(ComparisonEnum.LT, valor, this); 
	}
	
	public FieldCondition menorIgualque(Object valor){
		return new FieldCondition(ComparisonEnum.LET, valor, this); 
	}
	
	public FieldCondition like(Object valor){
		return new FieldCondition(ComparisonEnum.LIKE, valor, this); 
	}

	public String getEntidad() {
		return entity;
	}

	public void setEntidad(String entidad) {
		this.entity = entidad;
	}

	public String getNombre() {
		return fieldName;
	}

	public void setNombre(String nombre) {
		this.fieldName = nombre;
	}

}
