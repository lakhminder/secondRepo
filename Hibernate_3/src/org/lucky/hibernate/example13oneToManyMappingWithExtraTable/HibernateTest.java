package org.lucky.hibernate.example13oneToManyMappingWithExtraTable;


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
		User13 userDetails = new User13();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Vehicle13 vehicle = new Vehicle13();
		vehicle.setName("Accord");		
		
		Vehicle13 vehicle2 = new Vehicle13();
		vehicle2.setName("Ferrari");
		
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
