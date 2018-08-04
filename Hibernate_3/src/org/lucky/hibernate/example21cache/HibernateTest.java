package org.lucky.hibernate.example21cache;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.persistence.Cacheable;

//import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


/*
 * First level of Cache is provided by default for a session.
 * so for example
 *  1) select user1 i.e User20 user1 = (User20) session.get(User20.class, 1);
 *  2) updated user1 
 *  3) select user1
 *  
 *  At query level
 *  1) select query
 *  2) update Query
 ******************************************* 
 * For Second level cache
 * see in hibernate.cfg.xml as well
 * Added ehcache-core jar for this
 * Add following to respective entity 
 * @Cacheable
 * @Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
 * @Cache is in hibernate
 ********************************************
 * For Query cache
 * see HibernateTestQueryCache
 *
 */

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User21 userDetails = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
					 
		try{
			session.beginTransaction();
			User21 user = (User21) session.get(User21.class, 1);//refer logs for number of sql fired
			System.out.println("User name is :" + user.getUserName());
			user.setUserName("Testing 111111");	
			//user.setUserName("Testing second level cache");	
			session.getTransaction().commit();
			session.close();
			
			System.out.println("User name is :" + user.getUserName());
			
			//Open the another session
			Session session2 = sessionFactory.openSession();
			session2.beginTransaction();
			User21 user2 = (User21) session2.get(User21.class, 1);
			
			System.out.println("User name is :" + user2.getUserName());
			session2.getTransaction().commit();
			session2.close();
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
