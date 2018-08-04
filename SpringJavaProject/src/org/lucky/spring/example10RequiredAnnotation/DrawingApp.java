package org.lucky.spring.example10RequiredAnnotation;


import org.lucky.spring.example10RequiredAnnotation.shapes.Triangle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * @Required annotation is used to throw exception at bean initailization itself
 * For this use beanpostprocessor of spring
 * refer Triangle class  and spring.xml
 */
public class DrawingApp {

	private final static String XML_PATH = "org/lucky/spring/example10RequiredAnnotation/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		Triangle triangle = (Triangle) springContext.getBean("triangle");
		triangle.draw();
		

	}

}
