package org.lucky.spring.example12JSR250Annotations.shapes;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

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
	//If no name then bean with same name will be picked as of property
	//@Resource
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("Circle initialized!!");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Circle Destroyed!!");
	}

	
	
}
