package org.vidyq.client;


import org.vidyq.client.enums.ComparisonEnum;


public class ClientQueryField<FieldType> {

	//Name of the field
	private String fieldName;
	//Name of the entity that owns the field. Use Class.getSimpleName().
	private String entity;
	//Class of the field
	private final Class<FieldType> fieldType;


	public Class<FieldType> getType() {
		return this.fieldType;
	}

	public ClientQueryField(String entity, String fieldName, Class<FieldType> type) {
		super();
		this.entity = entity;
		this.fieldName = fieldName;
		this.fieldType = type;
	}

	public ClientFieldCondition eq(Object valor) {
		return new ClientFieldCondition(ComparisonEnum.EQ, valor, this);
	}

	public ClientFieldCondition neq(Object valor) {
		return new ClientFieldCondition(ComparisonEnum.NEQ, valor, this);
	}

	public ClientFieldCondition gt(Object valor) {
		return new ClientFieldCondition(ComparisonEnum.GT, valor, this);
	}

	public ClientFieldCondition get(Object valor) {
		return new ClientFieldCondition(ComparisonEnum.GET, valor, this);
	}

	public ClientFieldCondition lt(Object valor) {
		return new ClientFieldCondition(ComparisonEnum.LT, valor, this);
	}

	public ClientFieldCondition let(Object valor) {
		return new ClientFieldCondition(ComparisonEnum.LET, valor, this);
	}

	public ClientFieldCondition like(Object valor) {
		return new ClientFieldCondition(ComparisonEnum.LIKE, valor, this);
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Class<FieldType> getFieldType() {
		return fieldType;
	}

	
}
