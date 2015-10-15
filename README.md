# Vidyq
Prototype for creating dynamic querys from the view layer in a MVC pattern while keeping layers separated-

Small prototype to be able to do different querys to an entity from the view layer in an MVC pattern application for java.

It was build for a project with the following architecture:

-ProjectView: JSF view layer. Uses delegates on the ProjectClient layer to access the business layer. 
-ProjectClient: Defines Delegates and Facades. It does de lookup for the EJBs of the business layer. 
-ProjectBusiness: Implements the Facades defined by the client layer as remotes EJBs. It also containes the model and the DAO layer. 

In a nuthshell: model understand abount domain entities but view only knows about DTO. This project aims to allow the view layer to create dynamic querys for the DTOs and transform that query into a model query. If we have an entity Car and a CarDTO class for communication between the view and the business, we could do something like this in the view controller.

public class CarViewController {

	CarService carService;
	public List<CarDTO> getCarsByModelAndHorsePower(String model, Integer minumuHp){
		ClientQuery query = new ClientQuery();
		QCar qcar = QCar.qcar;
		query.and(qcar.model.eq(model)).and(qcar.horsePower.get(minumuHp)).orderBy(qcar.orderByHorsePower(OrderEnum.ASC));
		return carService.searchCars(query);
	}
}


How does it works?
Folder vidyq-example contains a little java project with three packages representing the mvc layers. 
