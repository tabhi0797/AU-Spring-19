package com.accolite.app.HibernateAssignment;

import org.hibernate.*;

import com.accolite.app.model.*;

/*
 *  1, 2, 3, 4, 5:
 *   saving and retrieving objects using hibernate
 *   primary key and value type (address)
 *   attribute overrides and embedded objects(address)
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = SessionFactoryUtil.sessionFactory;
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	
    	
    	Address address = new Address();
    	address.setCity("hyderabad");
    	address.setStreet("himayathnagar");
    	
    	Person p = new Person();
    	p.setName("abhinav");
    	p.setAddress(address);
    	
    	/*
    	 * p is in transient state
    	 */
    	session.save(p);
    	/*
    	 * p is in persistent state
    	 */
    	Person person = session.get(Person.class,1);
    	System.out.println(person);
    	
    	session.getTransaction().commit();
		session.close();
    }
}
