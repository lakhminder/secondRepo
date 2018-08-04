package org.lucky.spring.aop.example19AfterAdvice;


import org.aspectj.lang.annotation.Pointcut;
import org.lucky.spring.aop.example19AfterAdvice.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * //Note that advice won't be called at Spring initialization
 * Refer LoggingAspect.java and Circle.java
 */

public class MainApp {

	private final static String XML_PATH = "org/lucky/spring/aop/example19AfterAdvice/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		ShapeService shapeService = springContext.getBean("shapeService", ShapeService.class);
		//shapeService.getCircle().setName("To test Exception");
		//shapeService.getCircle().setNameAndReturn("To test args");
		shapeService.getCircle();
		//System.out.println(shapeService.getCircle().getName());
		//System.out.println(shapeService.getTriangle().getName());

	}

}
