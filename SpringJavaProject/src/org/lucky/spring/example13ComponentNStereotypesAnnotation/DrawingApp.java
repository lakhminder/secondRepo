package org.lucky.spring.example13ComponentNStereotypesAnnotation;


import org.lucky.spring.example13ComponentNStereotypesAnnotation.shapes.Shape;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/* 
 * @Component annotation is used to auto-registered as 
	Spring beans
 * 
 * refer Circle class  and spring.xml
 */
public class DrawingApp {

	private final static String XML_PATH = "org/lucky/spring/example13ComponentNStereotypesAnnotation/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		Shape shape = (Shape) springContext.getBean("circle");
		shape.draw();
		

	}

}
