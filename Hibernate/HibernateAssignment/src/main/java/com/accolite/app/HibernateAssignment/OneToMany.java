package com.accolite.app.HibernateAssignment;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.app.model.Customer;
import com.accolite.app.model.Vehicle;

/*
 * 8 & 9: one to many mapping, Cascade types
 */
public class OneToMany {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = SessionFactoryUtil.sessionFactory;
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
	
		
		Vehicle vehicle1 =new Vehicle();
		vehicle1.setReg_no("TS 08 ER 8218");
		
		Vehicle vehicle2 =new Vehicle();
		vehicle2.setReg_no("TS 11 AR 0082");
		
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(vehicle1);
		vehicles.add(vehicle2);
		
		Customer customer = new Customer();
		customer.setName("abhinav");
		customer.setVehicles(vehicles);
		
		session.save(vehicle1);
		session.save(vehicle2);
		session.save(customer);
		
		//business logic end
		session.getTransaction().commit();
		session.close();
	}

}
