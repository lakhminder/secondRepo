package org.lucky.spring.example13ComponentNStereotypesAnnotation.shapes;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//it will be same as 
//	<bean id="circle" class="org.lucky.spring.example13ComponentNStereotypesAnnotation.shapes.Circle" >
//	</bean>
@Component
public class Circle implements Shape{

	private Point center;
	
	public void draw(){
		
			System.out.println("Circle: " + center.getX() + "," + center.getY());
			
	}
	public Point getCenter() {
		return center;
	}
	
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}
		
}
