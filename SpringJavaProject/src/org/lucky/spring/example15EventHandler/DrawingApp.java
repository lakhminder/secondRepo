package org.lucky.spring.example15EventHandler;


import org.lucky.spring.example15EventHandler.shapes.Shape;



import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * ApplicationContext provides event handling support
 * 
 * 1) implement ApplicationListener to define listener
 * 2) make user define Event by extending ApplicationEvent
 * 3) Publish Event using ApplicationEventPublisher inside bean 
 * 		which implements ApplicationEventPublisherAware
 * 
 * Note: We could use ApplicationContext incase of ApplicationEventPublisher as 
 * ApplicationContext implements ApplicationEventPublisher
 * refer Circle.java
 */
public class DrawingApp {

	private final static String XML_PATH = "org/lucky/spring/example15EventHandler/spring.xml";
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
