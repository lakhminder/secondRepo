package org.lucky.spring.aop.example18JoinPoints;


import org.aspectj.lang.annotation.Pointcut;
import org.lucky.spring.aop.example18JoinPoints.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * JoinPoint is the place in code where advice can be applied in Jaspects
 * For spring join points are only method invocations
 * 
 * Also we can use args in advice
 * 
 * refer LoggingAspect.java
 */

public class MainApp {

	private final static String XML_PATH = "org/lucky/spring/aop/example18JoinPoints/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		ShapeService shapeService = springContext.getBean("shapeService", ShapeService.class);
		shapeService.getCircle().setName("To test args");
		System.out.println(shapeService.getCircle().getName());
		//System.out.println(shapeService.getTriangle().getName());

	}

}
