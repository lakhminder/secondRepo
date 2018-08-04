package org.lucky.hibernate.example11oneToManyMapping;


import java.util.Date;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/*
 * 
 */

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User11 userDetails = new User11();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Vehicle1 vehicle = new Vehicle1();
		vehicle.setName("Accord");		
		
		Vehicle1 vehicle2 = new Vehicle1();
		vehicle2.setName("Audi");
		
		userDetails.setUserName("Generated 1User");
		userDetails.getVehicleList().add(vehicle);
		userDetails.getVehicleList().add(vehicle2);
		
		vehicle.setUser(userDetails);
		vehicle2.setUser(userDetails);
		
		try{
			session.beginTransaction();
			session.save(userDetails);
			session.save(vehicle);
			session.save(vehicle2);
			session.getTransaction().commit();
			session.close();
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
