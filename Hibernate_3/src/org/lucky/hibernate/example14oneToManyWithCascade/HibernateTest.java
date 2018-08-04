package org.lucky.hibernate.example14oneToManyWithCascade;


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
		User14 userDetails = new User14();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Vehicle14 vehicle = new Vehicle14();
		vehicle.setName("Accord1111");		
		
		Vehicle14 vehicle2 = new Vehicle14();
		vehicle2.setName("Audi1111");
		
		userDetails.setUserName("Generated 111111111User");
		userDetails.getVehicleList().add(vehicle);
		userDetails.getVehicleList().add(vehicle2);
		
		vehicle.setUser(userDetails);
		vehicle2.setUser(userDetails);
		
		try{
			session.beginTransaction();
			session.persist(userDetails);
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
