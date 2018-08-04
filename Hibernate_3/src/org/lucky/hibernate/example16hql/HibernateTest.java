package org.lucky.hibernate.example16hql;


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
 * We can use parameter binding as well similar to prepared binding as of JDBC
 */

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User16 userDetails = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		
		/*try{
			session.beginTransaction();
			Query query = session.createQuery("from User16");
			query.setFirstResult(3);// rownumber to start with
			query.setMaxResults(5);// number of records to fetch
			
			List<User16> users = (List) query.list();
			System.out.println("Size is :" + users.size());
			for(User16 user: users)
			{
				System.out.println("User name is :" + user.getUserName());
			}
			session.getTransaction().commit();
			session.close();
			
		}*/
		
		/*
		 * Parameter binding
		try{
			session.beginTransaction();
			Query query = session.createQuery("from User16 where userId > ?");
			query.setInteger(0,5);// Position parameter
			
			//Query query = session.createQuery("from User16 where userId > :userId");
			//query.setInteger("userId",5); //Named parameter
			
			List<Map> users = (List<Map>) query.list();
			System.out.println("Size is :" + users.size());
			for(Map user: users)
			{
				System.out.println("User name is :" + user.get("1"));// Map 0=> userId & 1=> userName
			}
			session.getTransaction().commit();
			session.close();
			
		}*/
		 
		try{
			session.beginTransaction();
			Query query = session.createQuery("select new map(userId, userName) from User16");
			
			List<Map> users = (List<Map>) query.list();
			System.out.println("Size is :" + users.size());
			for(Map user: users)
			{
				System.out.println("User name is :" + user.get("1"));// Map 0=> userId & 1=> userName
			}
			session.getTransaction().commit();
			session.close();
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
