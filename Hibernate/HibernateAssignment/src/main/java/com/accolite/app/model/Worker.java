package com.accolite.app.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Worker")
public class Worker extends Employee
{
	
	int dailyWage;

	public int getDailyWage() {
		return dailyWage;
	}

	public void setDailyWage(int dailyWage) {
		this.dailyWage = dailyWage;
	}
	
}
