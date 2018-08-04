package org.lucky.spring.aop.example17PointCutsNWildcards;


import org.aspectj.lang.annotation.Pointcut;
import org.lucky.spring.aop.example17PointCutsNWildcards.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * We can use wildcards for specifying same advice for multiple points os execution
 * as used in LoggingAspect
 * 
 * Use @Pointcut to use multiple Advice for single point of execution(pointcut)
 * 
 * 1) @Pointcut("within(org.lucky.spring.aop.example17.model.*)") => applies to all classes directly in model folder
 * 2) @Pointcut("within(org.lucky.spring.aop.example17..*)") => applies to all classes including under subpackages in example17 folder
 * 
 * We can use logical operations on pointcuts to apply an advice
 */

public class MainApp {

	private final static String XML_PATH = "org/lucky/spring/aop/example17PointCutsNWildcards/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		ShapeService shapeService = springContext.getBean("shapeService", ShapeService.class);
		System.out.println(shapeService.getCircle().getName());
		//System.out.println(shapeService.getTriangle().getName());

	}

}
