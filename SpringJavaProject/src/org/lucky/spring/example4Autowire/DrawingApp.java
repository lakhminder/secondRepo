package org.lucky.spring.example4Autowire;


import org.lucky.spring.example4Autowire.shapes.Triangle;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/*
 * autowire is used to let Spring automatically inject beans based on its name from spring.xml
 * It can be used as byType and constructor as well
 */
public class DrawingApp {

	private final static String XML_PATH = "org/lucky/spring/example4Autowire/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Triangle triangle = new Triangle();
		//BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		Triangle triangle = (Triangle) springContext.getBean("triangle");
		triangle.draw();

	}

}
