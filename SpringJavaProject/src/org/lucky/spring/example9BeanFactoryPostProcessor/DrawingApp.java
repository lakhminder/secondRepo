package org.lucky.spring.example9BeanFactoryPostProcessor;


import org.lucky.spring.example9BeanFactoryPostProcessor.shapes.Triangle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * Refer spring.xml for beanFactoryPostProcessor
 * Spring also provide some default beanFactoryPostProcessor such as PropertyPlaceholderConfigurer
 * One usage of this is property placeholder i.e spring.xml reads peoperty files to get values
 * refer dev.properties
 */
public class DrawingApp {

	private final static String XML_PATH = "org/lucky/spring/example9BeanFactoryPostProcessor/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		Triangle triangle = (Triangle) springContext.getBean("triangle");
		triangle.draw();
		

	}

}
