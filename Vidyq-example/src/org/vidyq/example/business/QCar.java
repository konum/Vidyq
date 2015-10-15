package org.vidyq.example.business;

import java.util.Date;

import org.vidyq.client.ClientQueryField;
import org.vidyq.client.ClientQueryOrder;
import org.vidyq.client.QChecker;
import org.vidyq.client.enums.OrderEnum;

public class QCar {
	public static final QCar qcar = new QCar();
	
	private QCar(){};
	private static final String entity = CarDTO.class.getSimpleName();
	
	public ClientQueryField<Integer> id = new ClientQueryField<Integer>(entity, "id", Integer.class);
	public ClientQueryField<String> model = new ClientQueryField<String>(entity, "model", String.class);
	public ClientQueryField<Integer> numberDoors = new ClientQueryField<Integer>(entity, "numberDoors", Integer.class);
	public ClientQueryField<Integer> horsePower = new ClientQueryField<Integer>(entity, "horsePower", Integer.class);
	public ClientQueryField<Date> releaseDate = new ClientQueryField<Date>(entity, "id", Date.class);
	
	static{
		QChecker.checkQ(qcar, CarDTO.class);
	}
	public ClientQueryOrder orderById(OrderEnum order){
		return new ClientQueryOrder(order, id);
	}
	
	public ClientQueryOrder orderByModel(OrderEnum order){
		return new ClientQueryOrder(order, model);
	}
	
	public ClientQueryOrder orderByNumberDoors(OrderEnum order){
		return new ClientQueryOrder(order,numberDoors);
	}
	
	public ClientQueryOrder orderByHorsePower(OrderEnum order){
		return new ClientQueryOrder(order, horsePower);
	}

}
