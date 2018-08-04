package org.lucky.spring.example15EventHandler.shapes;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.lucky.spring.example15EventHandler.DrawEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;


public class Circle implements Shape, ApplicationEventPublisherAware{

	private Point center;
	private ApplicationEventPublisher publisher;
	
	
	public void draw(){
		
		System.out.println("Circle: " + center.getX() + "," + center.getY());
		DrawEvent event = new DrawEvent(this);
		publisher.publishEvent(event);
			
	}
	public Point getCenter() {
		return center;
	}
	
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}
	public ApplicationEventPublisher getPublisher() {
		return publisher;
	}
	public void setPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
	
	//publisher is instance of ApllicationContext only
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
		
	}
	
		
}
