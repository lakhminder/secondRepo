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
 *  
 * For Query cache
 * see in hibernate.cfg.xml as well
 * Added ehcache-core jar for this
 * Add following to respective Query 
 * query.setCacheable(true);
 */

public class HibernateTestQueryCache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User21 userDetails = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
					 
		try{
			session.beginTransaction();
			Query query = session.createQuery("from User21 user where user.userId = 1");//refer logs for number of sql fired
			query.setCacheable(true);
			System.out.println("User name is :" + query.list());
			session.getTransaction().commit();
			session.close();
			
			
			
			//Open the another session
			Session session2 = sessionFactory.openSession();
			session2.beginTransaction();
			Query query2 = session2.createQuery("from User21 user where user.userId = 1");
			query2.setCacheable(true);
			System.out.println("User name is :" + query2.list());
			session2.getTransaction().commit();
			session2.close();
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
