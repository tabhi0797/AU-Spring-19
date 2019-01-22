package com.accolite.app.model;

import javax.persistence.*;

@Entity(name="Person")
@Table(name="person")
public class Person {
	
	@Id
	@GeneratedValue
	int id;
	String name;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name = "street")),
		@AttributeOverride(name = "city", column = @Column(name = "city"))
		})
	private Address address;
	
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
}
