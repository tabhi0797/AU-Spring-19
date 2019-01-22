package com.accolite.app.model;

import javax.persistence.Embeddable;

/*
 * used for 3,4,5,6 
 */
@Embeddable
public class Address 
{
	String city;
	String street;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
}
