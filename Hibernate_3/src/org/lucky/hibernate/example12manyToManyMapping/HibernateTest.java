package org.lucky.hibernate.example12manyToManyMapping;


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
		User12 userDetails = new User12();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Vehicle12 vehicle = new Vehicle12();
		vehicle.setName("Accord");		
		
		Vehicle12 vehicle2 = new Vehicle12();
		vehicle2.setName("Audi");
		
		userDetails.setUserName("Generated 1User");
		userDetails.getVehicleList().add(vehicle);
		userDetails.getVehicleList().add(vehicle2);
		
		vehicle.getUserList().add(userDetails);
		vehicle2.getUserList().add(userDetails);
		
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
