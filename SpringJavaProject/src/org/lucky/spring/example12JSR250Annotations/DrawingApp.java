package org.lucky.spring.example12JSR250Annotations;


import org.lucky.spring.example12JSR250Annotations.shapes.Shape;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * These are JSR 250 Annotations (Note javax.annotations.*)
 * @Resource annotation is used for dependency injection
 * 1) It will go by name if provided else go by name of property
 * refer Circle class  and spring.xml
 */
public class DrawingApp {

	private final static String XML_PATH = "org/lucky/spring/example12JSR250Annotations/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		//For destroy stuff
		springContext.registerShutdownHook();
		Shape shape = (Shape) springContext.getBean("circle");
		shape.draw();
		

	}

}
