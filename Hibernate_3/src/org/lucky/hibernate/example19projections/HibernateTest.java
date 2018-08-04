package org.lucky.hibernate.example19projections;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

//import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


/*
 * Projections are used to specify grouping functions like count,max... 
 * and to sort the result
 * and to specify columns to be pulled instead of complete entity Object
 */

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User19 userDetails = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
					 
		try{
			session.beginTransaction();
			Criteria criteria = session.createCriteria(User19.class)
								//.setProjection(Projections.property("userName"));// to Pull only names
								//.addOrder(Order.desc("userName"));// to sort
								.setProjection(Projections.max("userId"));
			
			List<User19> users = (List) criteria.list();
			System.out.println("Size is :" + users.size());
			for(User19 user: users)
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
