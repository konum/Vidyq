package org.vidyq.example.business;

import java.util.ArrayList;
import java.util.List;

import org.vidyq.business.ModelQuery;
import org.vidyq.client.ClientQuery;
import org.vidyq.example.model.Car;
import org.vidyq.example.model.CarDao;

public class CarService {
	
	CarDao dao;

	public List<CarDTO> searchCars(ClientQuery query){
		List<CarDTO> retorno = new ArrayList<CarDTO>();
		List<Car> listEntities = dao.search(new ModelQuery(query, Car.class));
		for (Car car : listEntities) {
			//transform car entities to carDTO.
		}
		return retorno;
	}
}
