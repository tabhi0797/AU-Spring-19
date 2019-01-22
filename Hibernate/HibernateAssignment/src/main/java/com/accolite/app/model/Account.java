package com.accolite.app.model;

import javax.persistence.*;

@Entity
public class Account {

	@Id
	@GeneratedValue
	int id;
	
	String accNumber;
	int balance;
	
	@OneToOne(mappedBy="account")
	private Employee employee;
	
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
