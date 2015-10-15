package org.vidyq.example.view;

import java.util.List;

import org.vidyq.client.ClientQuery;
import org.vidyq.example.business.CarDTO;
import org.vidyq.example.business.CarService;
import org.vidyq.example.business.QCar;

public class CarViewController {

	CarService carService;
	public List<CarDTO> getCarsByModelAndHorsePower(String model, Integer minumuHp){
		ClientQuery query = new ClientQuery();
		QCar qcar = QCar.qcar;
		query.and(qcar.model.eq(model)).and(qcar.horsePower.get(minumuHp));
		return carService.searchCars(query);
	}
}
