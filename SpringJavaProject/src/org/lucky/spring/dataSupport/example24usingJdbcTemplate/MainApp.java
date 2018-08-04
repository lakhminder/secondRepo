package org.lucky.spring.dataSupport.example24usingJdbcTemplate;


import org.lucky.spring.dataSupport.example24usingJdbcTemplate.dao.JdbcDaoImpl;
import org.lucky.spring.dataSupport.example24usingJdbcTemplate.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *1) how to ude jdbcTemplate
 *2) use of RowMapper for returning model objects
 *
 *refer JdbcDaoImpl
 */

public class MainApp {

	private final static String XML_PATH = "org/lucky/spring/dataSupport/example24usingJdbcTemplate/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		JdbcDaoImpl dao = springContext.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		//System.out.println(dao.getCircleCount());
		//System.out.println(dao.getCircleName(1));
		//System.out.println(dao.getCircleForId(1).getName());
		dao.insertCircle1(new Circle(4,"name_4"));
		System.out.println(dao.getCircleList().size());
		//dao.createTriangle();
		

	}

}
