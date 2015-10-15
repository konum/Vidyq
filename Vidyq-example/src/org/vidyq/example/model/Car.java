package org.vidyq.example.model;

import java.util.Date;

/**
 * This class represents a model entity. No JPA annotations are present to keep example light.
 * @author ggefaell
 *
 */
public class Car {

	private Integer id;
	
	private String model;
	
	private Integer numberDoors;
	private Integer horsePower;
	private Date releaseDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getNumberDoors() {
		return numberDoors;
	}
	public void setNumberDoors(Integer numberDoors) {
		this.numberDoors = numberDoors;
	}
	public Integer getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(Integer horsePower) {
		this.horsePower = horsePower;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
	
}
