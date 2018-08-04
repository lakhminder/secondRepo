package org.lucky.hibernate.example6embeddedObject;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.lucky.hibernate.example6embeddedObject.User6;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User6 userDetails = new User6();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Address address = new Address();
		address.setCity("city6");
		address.setState("Delhi");
		
		Address officeAddress = new Address();
		officeAddress.setCity("city7");
		officeAddress.setState("Delhi7");
		
		userDetails.setUserName("Generated 1User");
		userDetails.setHomeAddress(address);
		userDetails.setOfficeAddress(officeAddress);
		userDetails.setJoinDate(new Date());
		userDetails.setDescription("desc");
				
		try{
			
			System.out.println(userDetails.getUserName());
			
			session.beginTransaction();
			session.save(userDetails);
			session.getTransaction().commit();
			session.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
