package org.lucky.spring.example11AutowireAnnotation.shapes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Circle implements Shape{

	private Point center;
	
	public void draw(){
		
			System.out.println("Circle: " + center.getX() + "," + center.getY());
			
	}
	public Point getCenter() {
		return center;
	}
	@Autowired
	@Qualifier("circleRelated")
	//@Qualifier("pointA")
	public void setCenter(Point center) {
		this.center = center;
	}

	
	
}
