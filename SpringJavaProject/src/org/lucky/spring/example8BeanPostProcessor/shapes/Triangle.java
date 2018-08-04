package org.lucky.spring.example8BeanPostProcessor.shapes;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle {

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
	
}
