package org.lucky.spring.aop.example20CustomAdviceAnnotation.aspect;

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
	
	//Specifying this advice to run for each loggable pointcut
	@Around("@annotation(org.lucky.spring.aop.example20CustomAdviceAnnotation.aspect.Loggable)")
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
	
}
