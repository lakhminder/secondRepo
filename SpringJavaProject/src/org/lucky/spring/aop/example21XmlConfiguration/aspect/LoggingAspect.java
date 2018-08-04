package org.lucky.spring.aop.example21XmlConfiguration.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
public class LoggingAspect {
	
	
	//@Around("allGetters()")
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
	
	//@Pointcut("execution(public * get*())")
	//public void allGetters(){}
}
