package org.lucky.spring.example6BeanDefinitionInheritance;


import org.lucky.spring.example6BeanDefinitionInheritance.shapes.Triangle;
import org.lucky.spring.example6BeanDefinitionInheritance.shapes.Triangle1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * We can use bean definition inheritance incase of list as well as shown in 
 * Triangle1 with merge attribute
 * Abstract causes spring not to initialize the bean and instead just use it as template
 * for others
 */
public class DrawingApp {

	private final static String XML_PATH = "org/lucky/spring/example6BeanDefinitionInheritance/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Triangle triangle = new Triangle();
		//BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		Triangle triangle = (Triangle) springContext.getBean("triangle");
		triangle.draw();
		//Using the list as Abstract
		System.out.println("**************");
		Triangle1 triangle1 = (Triangle1) springContext.getBean("triangle1");
		triangle1.draw();

	}

}
