package org.lucky.spring.aop.example20CustomAdviceAnnotation;


import org.aspectj.lang.annotation.Pointcut;
import org.lucky.spring.aop.example20CustomAdviceAnnotation.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * This form of advice is more readable as it is defined in beans itself
 * Refer LoggingAspect.java and Triangle.java and Loggable.java(Custom annotation)
 */

public class MainApp {

	private final static String XML_PATH = "org/lucky/spring/aop/example20CustomAdviceAnnotation/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		ShapeService shapeService = springContext.getBean("shapeService", ShapeService.class);
		shapeService.getTriangle().getName();
		

	}

}
