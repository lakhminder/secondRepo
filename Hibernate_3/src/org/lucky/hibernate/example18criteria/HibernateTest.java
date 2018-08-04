package org.lucky.hibernate.example18criteria;


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
import org.hibernate.criterion.Restrictions;


/*
 * Restrictions.eq("userName", "name 10") gives the Criteria Object( org.hibernate.criterion.SimpleExpression)
 */

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User18 userDetails = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
					 
		try{
			session.beginTransaction();
			Criteria criteria = session.createCriteria(User18.class);
			criteria.add(Restrictions.eq("userName", "name 10"));
			//for AND Condition
			/*criteria.add(Restrictions.eq("userName", "name 10"))
					.add(Restrictions.eq("userName", "name 2"));
			//For OR Condition
			criteria.add(Restrictions.or(Restrictions.eq("userName", "name 10"), Restrictions.eq("userName", "name 2")));
			*/
			List<User18> users = (List) criteria.list();
			System.out.println("Size is :" + users.size());
			for(User18 user: users)
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
