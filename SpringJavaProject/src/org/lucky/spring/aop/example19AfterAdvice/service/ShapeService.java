package org.lucky.spring.aop.example19AfterAdvice.service;

import org.lucky.spring.aop.example19AfterAdvice.model.Circle;
import org.lucky.spring.aop.example19AfterAdvice.model.Triangle;

public class ShapeService {

	private Triangle triangle;
	private Circle circle;
	
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
}
