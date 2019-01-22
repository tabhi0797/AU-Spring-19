package com.accolite.app.HibernateAssignment;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.accolite.app.model.*;

/*
 *   11,12,13,14,15,16,17,18,19 are used here
 */
public class DBOperations {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = SessionFactoryUtil.sessionFactory;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/*
		 * CRUD
		 */
		Vehicle v1 = new Vehicle(); v1.setReg_no("AP 12 EX 2000");
		Vehicle v2 = new Vehicle(); v2.setReg_no("AP 13 EX 2001");
		Vehicle v3 = new Vehicle(); v3.setReg_no("AP 14 EX 2002");
		Vehicle v4 = new Vehicle(); v4.setReg_no("AP 15 EX 2003");
		
		session.save(v1);
		session.save(v2);
		session.save(v3);
		session.save(v4);

		Vehicle v5 = session.get(Vehicle.class, 1);
		Vehicle v6 = session.get(Vehicle.class, 4);
		v5.setReg_no("TS 12 EX 2000");
		
		session.delete(v6);
		
		
		/*
		 * HQL and Query, Pagination, namedQueries , parameter binding
		 */
		Query query1 = session.createQuery("FROM Vehicle where id >= 2");
		query1.setMaxResults(2);
		List<Vehicle> vehicles = query1.list();
		System.out.println("list of vehicles:");
		for(Vehicle vehicle:vehicles)
		{
			System.out.println(vehicle);
		}
		
		
		Query query2 = session.createNamedQuery("getAllRegNos");
		//query2.setParameter(0, 1);
		System.out.println("named query : list of vehicles id>1 :");
		for(Vehicle vehicle:vehicles)
		{
			System.out.println(vehicle);
		}
		
		
		/*
		 *  Criterion, Restrictions, Projections 
		 */
		Criteria criteria2 = session.createCriteria(Vehicle.class);
		criteria2.add(Restrictions.between("id", 2, 4));
		criteria2.addOrder(Order.desc("id"));
		System.out.println("criterion projection : "+criteria2.list());
		
		
		/*
		 * vehicle objects are cached in level 2 cache because of @Cacheble
		 */
		
		session.getTransaction().commit();
		session.close();
	}
}
