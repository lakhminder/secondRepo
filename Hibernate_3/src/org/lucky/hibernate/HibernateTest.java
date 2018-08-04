package org.lucky.hibernate;

import java.lang.reflect.Field;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.lucky.hibernate.example4.User;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User userDetails = new User();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		userDetails.setUserId(2);
		userDetails.setUserName("third User");
		userDetails.setAddress("Adddress");
		userDetails.setJoinDate(new Date());
		userDetails.setDescription("desc");
				
		try{
			//Reflection API's
			/*Field field = userDetails.getClass().getDeclaredField("userName");
			field.setAccessible(true);
			System.out.println(field.get(userDetails));*/
			System.out.println(userDetails.getUserName());
			
			//session.beginTransaction();
			//session.save(userDetails);
			//session.getTransaction().commit();
			//session.close();
			
			//To retrieve data
			userDetails = null;
			//session = sessionFactory.openSession();
			session.beginTransaction();
			userDetails = (User) session.get(User.class, 2);
			System.out.println("Retrieved from DB:" + userDetails.getUserName());
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
