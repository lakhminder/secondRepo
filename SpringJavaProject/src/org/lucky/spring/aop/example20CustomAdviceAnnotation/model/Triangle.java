package org.lucky.spring.aop.example20CustomAdviceAnnotation.model;

import org.lucky.spring.aop.example20CustomAdviceAnnotation.aspect.Loggable;


public class Triangle {

	private String name;

	@Loggable
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
		
}
