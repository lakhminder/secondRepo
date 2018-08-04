package org.lucky.spring.aop.example21XmlConfiguration;


import org.aspectj.lang.annotation.Pointcut;
import org.lucky.spring.aop.example21XmlConfiguration.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Refer spring.xml for defining LoggingAspect
 */

public class MainApp {

	private final static String XML_PATH = "org/lucky/spring/aop/example21XmlConfiguration/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		ShapeService shapeService = springContext.getBean("shapeService", ShapeService.class);
		shapeService.getTriangle();
		

	}

}
