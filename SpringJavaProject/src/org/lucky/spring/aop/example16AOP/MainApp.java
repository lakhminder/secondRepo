package org.lucky.spring.aop.example16AOP;


import org.lucky.spring.aop.example16AOP.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * for AOP include <aop:aspectj-autoproxy/> in spring.xml
 * and make aspect(LoggingAspect.java) and configure in spring.xml
 */

public class MainApp {

	private final static String XML_PATH = "org/lucky/spring/aop/example16AOP/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		ShapeService shapeService = springContext.getBean("shapeService", ShapeService.class);
		System.out.println(shapeService.getCircle().getName());
		System.out.println(shapeService.getTriangle().getName());

	}

}
