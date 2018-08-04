package org.lucky.spring.aop.example19AfterAdvice.model;

import org.aspectj.lang.annotation.AfterThrowing;


public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle setter called with value: " + name);
		//Remember to comment out initialization of property name in spring.xml
		throw new RuntimeException("to test @AfterThrowing Advice");
	}
	
	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("Circle setter called with value: " + name);
		return name;
	}
		
}
