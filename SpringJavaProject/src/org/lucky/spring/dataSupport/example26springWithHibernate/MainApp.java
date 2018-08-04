package org.lucky.spring.dataSupport.example26springWithHibernate;


import org.lucky.spring.dataSupport.example26springWithHibernate.dao.HibernateDaoImpl;
import org.lucky.spring.dataSupport.example26springWithHibernate.dao.JdbcDaoImpl;
import org.lucky.spring.dataSupport.example26springWithHibernate.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 
 * configure hibernate session factory as spring bean(as both are singleton like usage in application)
 * 
 * refer HibernateDaoImpl
 */

public class MainApp {

	private final static String XML_PATH = "org/lucky/spring/dataSupport/example26springWithHibernate/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		HibernateDaoImpl dao = springContext.getBean("hibernateDaoImpl",HibernateDaoImpl.class);
		System.out.println(dao.getCircleCount());
		//System.out.println(dao.getCircleName(1));
		//System.out.println(dao.getCircleForId(1).getName());
		//dao.insertCircle1(new Circle(4,"name_4"));
		//System.out.println(dao.getCircleCount());
		//dao.createTriangle();
		

	}

}
