package org.lucky.hibernate.example17namedAndNativeQuery;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

//import javax.persistence.Query;

import org.hibernate.Query;
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
		User17 userDetails = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
					 
		try{
			session.beginTransaction();
			Query query = session.getNamedQuery("UserDetails.ById");
			query.setInteger("userId", 1);
			
			List<User17> users = (List) query.list();
			System.out.println("Size is :" + users.size());
			for(User17 user: users)
			{
				System.out.println("User name is :" + user.getUserName());
			}
			
			//For Native Query
			query = session.getNamedQuery("UserDetails.ByName");
			query.setString(0, "name 6");
			
			List<User17> nativeUsers = (List) query.list();
			System.out.println("Size is :" + users.size());
			for(User17 user: nativeUsers)
			{
				System.out.println("User name is :" + user.getUserName());
			}
			session.getTransaction().commit();
			session.close();
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
