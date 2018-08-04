package org.lucky.hibernate.example20queryByExample;


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
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


/*
 * QueryByExample(QBE) is used when dealing with very large number of criteria's/Restrictions
 * Hibernate ignores the primary key property of Example in addition to properties which are not set
 */

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User20 userDetails = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
					 
		try{
			session.beginTransaction();
			User20 user = new User20();
			user.setUserId(11); // primary key will be ignored
			user.setUserName("name 11");
			
			Example example = Example.create(user); // Create an example
			//Example example1 = Example.create(user).excludeProperty("userName"); // if want to explicitly exclude certain properties as they can have values set to them
																				// but hibernate will still ignore them
			//if want to use like operation in example
			/*user.setUserName("name 1%");
			Example example = Example.create(user).enableLike();*/
			
			Criteria criteria = session.createCriteria(User20.class)
								.add(example);
			
			List<User20> users = (List) criteria.list();
			System.out.println("Size is :" + users.size());
			for(User20 usr: users)
			{
				System.out.println("User name is :" + usr.getUserName());
			}
			
			
			session.getTransaction().commit();
			session.close();
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
