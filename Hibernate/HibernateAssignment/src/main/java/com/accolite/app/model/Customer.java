package com.accolite.app.model;

import java.util.Collection;

import javax.persistence.*;
import java.util.*;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	Collection<Vehicle> vehicles;
	
	
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
