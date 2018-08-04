package org.lucky.spring.example7LifecycleCallback.shapes;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements InitializingBean, DisposableBean{

	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	
	public void draw(){
		
			System.out.println(pointA.getX() + "," + pointA.getY());
			System.out.println(pointB.getX() + "," + pointB.getY());
			System.out.println(pointC.getX() + "," + pointC.getY());
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Bean Init method called!!");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean Bean Destroy method called!!");
		
	}
	
	//configured in spring.xml
	public void myInit(){
		System.out.println("My Init method called!!");
	}
	
	//Configured in spring.xml
	public void myCleanUp(){
		System.out.println("My CleanUp method called!!");
	}
	
}
