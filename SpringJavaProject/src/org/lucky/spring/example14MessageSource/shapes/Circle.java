package org.lucky.spring.example14MessageSource.shapes;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;


public class Circle implements Shape{

	private Point center;
	@Autowired
	private MessageSource messageSource; 
	
	public void draw(){
		System.out.println("Circle Message : " + this.messageSource.getMessage("greeting.message", null, "default message", null));
		//System.out.println("Circle: " + center.getX() + "," + center.getY());
		System.out.println(this.messageSource.getMessage("circle.point.message", new Object[]{center.getX(),center.getY()}, "default message", null));
			
	}
	public Point getCenter() {
		return center;
	}
	
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}
	public MessageSource getMessageSource() {
		return messageSource;
	}
	
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
		
}
