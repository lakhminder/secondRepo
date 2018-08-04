package org.lucky.hibernate.example9eagerLoadingOfCollection;


import java.util.Date;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.lucky.hibernate.example9eagerLoadingOfCollection.User9;

/*
 * by default the hibernate goes for lazy loading/fetching i.e it will pull the collection later when 
 * the getter for that is invoked
 * Hibernate does by creating the proxyObject which extends the User9 and overrides the implemention of getListOfAddresses()
 */

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User9 userDetails =null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		/*Address address = new Address();
		address.setCity("city6");
		address.setState("Delhi");
		
		Address officeAddress = new Address();
		officeAddress.setCity("city7");
		officeAddress.setState("Delhi7");
				
		userDetails.setUserName("Generated 1User");
		
		userDetails.getListOfAddresses().add(address);
		userDetails.getListOfAddresses().add(officeAddress);
		
		
		userDetails.setJoinDate(new Date());
		userDetails.setDescription("desc");*/
				
		try{
			userDetails = (User9) session.get(User9.class, 23);
			System.out.println("Lucky: Loading the Collection now...");
			//System.out.println(userDetails.getListOfAddresses().size());
			/*session.beginTransaction();
			session.save(userDetails);
			session.getTransaction().commit();*/
			session.close();
			//works with even after session.close for eager type fetching
			System.out.println(userDetails.getListOfAddresses().size());
			
		}catch(Exception e){
			e.printStackTrace();
			//session.getTransaction().rollback();
		}
		
	}

}
