package org.lucky.spring.example14MessageSource;


import org.lucky.spring.example14MessageSource.shapes.Shape;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * ApplicationContext provides messaging support
 * 
 * Use <bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
 * for message externalization and i18n
 * 
 * refer spring.xml
 * To get message either use ApplicationContext(in bean as well as explained in earlier tutorials)
 * or inject messageSource bean(interface) into the bean like Circle.java
 */
public class DrawingApp {

	private final static String XML_PATH = "org/lucky/spring/example14MessageSource/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		Shape shape = (Shape) springContext.getBean("circle");
		shape.draw();
		//System.out.println(springContext.getMessage("greeting.message", null, "default message", null));

	}

}
