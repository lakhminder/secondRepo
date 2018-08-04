package org.lucky.spring.aop.example18JoinPoints.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	
	@Before("allCircleMethods()")
	public void loggingAdvice(JoinPoint joinPoint){
		System.out.println("Logging Advice called!!");
		System.out.println(joinPoint.toString());
	}
	
	//Pointcut for all circle methods
	@Pointcut("within(org.lucky.spring.aop.example18JoinPoints.model.Circle)")
	public void allCircleMethods(){}
	
	//One way of using args
	/*@Before("args(String)")
	public void stringArgumentAdvice(){
		System.out.println("A single String argument method advice called!!");
	}*/
	
	
	//Note that this advice won't be called at Spring initialization
	@Before("args(name)")
	public void stringArgumentAdvice(String name){
		System.out.println("A single String argument method advice called!!" + "value is :" + name);
	}
	
	
}
