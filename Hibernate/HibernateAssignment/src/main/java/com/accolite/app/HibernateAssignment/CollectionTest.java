package com.accolite.app.HibernateAssignment;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.app.model.*;

/*
 * 6 : storing a collection of objects
 */
public class CollectionTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryUtil.sessionFactory;
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	
    	Address address1 = new Address();
    	address1.setCity("hyderabad");
    	address1.setStreet("gachibowli");
    	
    	Address address2 = new Address();
    	address2.setCity("bangalore");
    	address2.setStreet("gandhinagar");
    	
    	List<Address> addresses = new ArrayList<Address>();
    	addresses.add(address1);
    	addresses.add(address2);
    	
    	Organization org = new Organization();
    	org.setName("Accolite");
    	org.setAddresses(addresses);
    	
    	session.save(org);
    	
    	session.getTransaction().commit();
		session.close();
	}
}
