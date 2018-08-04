package org.lucky.spring.example11AutowireAnnotation;


import org.lucky.spring.example11AutowireAnnotation.shapes.Shape;
import org.lucky.spring.example11AutowireAnnotation.shapes.Triangle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * @Autowired annotation is used to wire bean automatically
 * 1) It will go by type first
 * 2) If multiple beans found for same type then it will go by name
 * 3) We can also direct spring to use Qualifier if we can't change bean name
 * Note: for qualifier we have to include namespaces... refer spring.xml <Beans>
 * 4) use <context:annotation-config/> to configure all beanPost Processors that spring provide
 * For this use beanpostprocessor of spring
 * refer Circle class  and spring.xml
 */
public class DrawingApp {

	private final static String XML_PATH = "org/lucky/spring/example11AutowireAnnotation/spring.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(XML_PATH);
		Shape shape = (Shape) springContext.getBean("circle");
		shape.draw();
		

	}

}
