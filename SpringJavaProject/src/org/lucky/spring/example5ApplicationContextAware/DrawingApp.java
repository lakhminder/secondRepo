package org.lucky.spring.example5ApplicationContextAware;


import org.lucky.spring.example5ApplicationContextAware.shapes.Triangle;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/*
 * By using ApplicationContextAware we can use the applicationContext of 
 * Spring to inject dependencies
 * Refer Triangle.java
 */
public class DrawingApp {

	private final static String XML_PATH = "org/lucky/spring/example5ApplicationContextAware/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Triangle triangle = new Triangle();
		//BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		Triangle triangle = (Triangle) springContext.getBean("triangle");
		//To populate the dependencies from within Managed Bean using Spring Context
		triangle.populateDependencies();
		triangle.draw();

	}

}
