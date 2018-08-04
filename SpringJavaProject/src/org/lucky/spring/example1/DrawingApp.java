package org.lucky.spring.example1;

import org.lucky.spring.example1.shapes.Triangle;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Triangle triangle = new Triangle();
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("src/org/lucky/spring/example1/spring.xml"));
		Triangle triangle = (Triangle) beanFactory.getBean("triangle");
		triangle.draw();

	}

}
