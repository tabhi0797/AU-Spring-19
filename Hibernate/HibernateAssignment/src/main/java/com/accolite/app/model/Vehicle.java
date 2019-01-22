package com.accolite.app.model;

import javax.persistence.*;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQueries(value = { 
		@NamedQuery(name = "getAllRegNos", query = "select reg_no from Vehicle where id > 1")
		})
public class Vehicle {
	
	@Id
	@GeneratedValue
	private int id;
	private String reg_no;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
	
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", reg_no=" + reg_no + "]";
	}
	
}
