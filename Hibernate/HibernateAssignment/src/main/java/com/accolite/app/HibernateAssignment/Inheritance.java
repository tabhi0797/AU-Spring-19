package com.accolite.app.HibernateAssignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.app.model.*;


/*
 * 10: inheritance
 */
public class Inheritance {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = SessionFactoryUtil.sessionFactory;
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	
    	Account account = new Account();
        account.setAccNumber("123-345-65454");
		
		Employee emp = new Employee();
		emp.setName("abhinav");
		emp.setAccount(account);
		emp.setCompany("accolite");
		
		Worker dev = new Worker();
		dev.setDailyWage(2000);
		
		session.save(account);
		session.save(emp);
		session.save(dev);
		
		
		session.getTransaction().commit();
		session.close();
	}
}
