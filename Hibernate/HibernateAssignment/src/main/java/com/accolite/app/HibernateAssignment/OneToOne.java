package com.accolite.app.HibernateAssignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.app.model.*;

/*
 * 7: one to one mapping
 */
public class OneToOne {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = SessionFactoryUtil.sessionFactory;
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	
		Account account = new Account();
        account.setAccNumber("123-345-65454");
 
        Employee emp = new Employee();
        emp.setName("abhinav");
        emp.setCompany("accolite");
        emp.setAccount(account);
        
        session.save(emp);
        session.save(account);
        session.getTransaction().commit();
		session.close();
        
	}
}
