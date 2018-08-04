package org.lucky.spring.aop.example20CustomAdviceAnnotation.service;

import org.lucky.spring.aop.example20CustomAdviceAnnotation.model.Circle;
import org.lucky.spring.aop.example20CustomAdviceAnnotation.model.Triangle;

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
