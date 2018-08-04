package org.lucky.spring.example6BeanDefinitionInheritance.shapes;

import java.util.List;

import org.lucky.spring.example6BeanDefinitionInheritance.shapes.Point;


public class Triangle1 {

	private List<Point> points;
	
	public void draw(){
		
		for(Point point : points)
			System.out.println(point.getX() + "," + point.getY());
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
}
