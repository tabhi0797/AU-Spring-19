package com.accolite.app.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "EMP_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("employee")
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue
	int id;
	String name;
	String company;
	
	@OneToOne
	@JoinColumn(name="ACCOUNT_ID")
	private Account account;
	
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

}
