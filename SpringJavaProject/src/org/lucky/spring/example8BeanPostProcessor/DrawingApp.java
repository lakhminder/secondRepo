package org.lucky.spring.example8BeanPostProcessor;


import org.lucky.spring.example8BeanPostProcessor.shapes.Triangle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * Refer spring.xml for beanPostProcessor
 */
public class DrawingApp {

	private final static String XML_PATH = "org/lucky/spring/example8BeanPostProcessor/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		Triangle triangle = (Triangle) springContext.getBean("triangle");
		triangle.draw();
		

	}

}
