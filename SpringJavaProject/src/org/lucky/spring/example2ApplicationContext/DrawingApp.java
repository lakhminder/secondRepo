package org.lucky.spring.example2ApplicationContext;


import org.lucky.spring.example2ApplicationContext.shapes.Triangle;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
/*
 * ApplicationContext is superSet of BeanFactory
 * Also you can set the member variables of Object being initialized in spring.xml as follows
 * <property name="type" value="Equilateral"/>
 * This is setter injection.
 * We can use constructor injection as well
 */
public class DrawingApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Triangle triangle = new Triangle();
		//BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext springContext = new ClassPathXmlApplicationContext("org/lucky/spring/example2ApplicationContext/spring.xml");
		Triangle triangle = (Triangle) springContext.getBean("triangle");
		triangle.draw();

	}

}
