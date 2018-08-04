package org.lucky.spring.aop.example18JoinPoints.model;


public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle setter called with value: " + name);
	}
	
	
		
}
