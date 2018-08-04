package org.lucky.hibernate.example10oneToOneMapping;


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
		User10 userDetails = new User10();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Accord");		
		
		userDetails.setUserName("Generated 1User");
		userDetails.setVehicle(vehicle);
		
		try{
			session.beginTransaction();
			session.save(userDetails);
			session.save(vehicle);
			session.getTransaction().commit();
			session.close();
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
