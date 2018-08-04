package org.lucky.spring.aop.example19AfterAdvice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

		
	//Note that this advice won't be called at Spring initialization
	@After("args(name)")
	public void stringArgumentAdvice(String name){
		System.out.println("After Advice called");
	}
	
	/*@AfterReturning("args(name)")
	public void successAdvice(String name){
		System.out.println("After success Advice called");
	}
	
	@AfterThrowing("args(name)")
	public void exceptionAdvice(String name){
		System.out.println("After Exception Advice called");
	}*/
	
	@AfterReturning(pointcut="args(name)", returning="returnObject")
	public void successAdvice(String name, String returnObject){
		System.out.println("After success Advice called with return value:" + returnObject);
	}
	
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void exceptionAdvice(String name, RuntimeException ex){
		System.out.println("After Exception Advice called" + ex.getMessage());
	}
	
	//Around advice is used when both before and after stuff is needed
	@Around("allGetters()")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		Object returnValue = null;
		try{
			System.out.println("Before Advice****");
			returnValue = proceedingJoinPoint.proceed();//Invocation of target method
			System.out.println("After returning****");
		}catch(Throwable e){
			System.out.println("After Throwing****");
		}
		System.out.println("After Finally****");
		return returnValue;
	}
	
	@Pointcut("execution(public * get*())")
	public void allGetters(){}
	
	
}
