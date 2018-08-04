package org.lucky.hibernate.example15inheritance;


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
		User15 userDetails = new User15();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Vehicle15 vehicle = new Vehicle15();
		vehicle.setName("Accord");		
		
		TwoWheeler vehicle2 = new TwoWheeler();
		vehicle2.setName("Audi");
		
		userDetails.setUserName("Generated 1User");
		userDetails.getVehicleList().add(vehicle);
		userDetails.getVehicleList().add(vehicle2);	
		
		
		try{
			session.beginTransaction();
			session.save(userDetails);
			//session.save(vehicle);
			//session.save(vehicle2);
			session.getTransaction().commit();
			session.close();
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
