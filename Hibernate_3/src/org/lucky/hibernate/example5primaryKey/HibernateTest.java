package org.lucky.hibernate.example5primaryKey;

import java.lang.reflect.Field;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.lucky.hibernate.example5primaryKey.User5;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User5 userDetails = new User5();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//userDetails.setUserId(2);
		userDetails.setUserName("Generated 1User");
		userDetails.setAddress("Adddress");
		userDetails.setJoinDate(new Date());
		userDetails.setDescription("desc");
				
		try{
			//Reflection API's
			/*Field field = userDetails.getClass().getDeclaredField("userName");
			field.setAccessible(true);
			System.out.println(field.get(userDetails));*/
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
