package org.lucky.spring.dataSupport.example22jdbcWithoutSpring;


import org.aspectj.lang.annotation.Pointcut;
import org.lucky.spring.aop.example20CustomAdviceAnnotation.service.ShapeService;
import org.lucky.spring.dataSupport.example22jdbcWithoutSpring.dao.JdbcDaoImpl;
import org.lucky.spring.dataSupport.example22jdbcWithoutSpring.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *
 */

public class MainApp {

	private final static String XML_PATH = "org/lucky/spring/aop/example20CustomAdviceAnnotation/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Circle circle = new JdbcDaoImpl().getCircle(1);
		System.out.println(circle.getName());
		

	}

}
