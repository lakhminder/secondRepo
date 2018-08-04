package org.lucky.spring.example7LifecycleCallback;


import org.lucky.spring.example7LifecycleCallback.shapes.Triangle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * AbstractApplicationContext is used just for desktop application to register shutdownhook
 * InitializingBean, DisposableBean provide the methods which are called when 
 * spring initialize/destroy bean
 * 
 * We can configure our init/destroy method in spring.xml
 * 
 * For init/destroy method at all beans level do following
 * <beans default-init-method="myInit" default-destroy-method="myCleanUp">
 */
public class DrawingApp {

	private final static String XML_PATH = "org/lucky/spring/example7LifecycleCallback/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		springContext.registerShutdownHook();
		Triangle triangle = (Triangle) springContext.getBean("triangle");
		triangle.draw();
		

	}

}
