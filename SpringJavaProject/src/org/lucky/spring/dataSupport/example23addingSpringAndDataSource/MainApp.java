package org.lucky.spring.dataSupport.example23addingSpringAndDataSource;


import org.lucky.spring.dataSupport.example23addingSpringAndDataSource.dao.JdbcDaoImpl;
import org.lucky.spring.dataSupport.example23addingSpringAndDataSource.model.Circle;
import org.lucky.spring.example13ComponentNStereotypesAnnotation.shapes.Shape;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *
 */

public class MainApp {

	private final static String XML_PATH = "org/lucky/spring/dataSupport/example23addingSpringAndDataSource/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		JdbcDaoImpl dao = springContext.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		Circle circle = dao.getCircle(1);
		System.out.println(circle.getName());
		

	}

}
