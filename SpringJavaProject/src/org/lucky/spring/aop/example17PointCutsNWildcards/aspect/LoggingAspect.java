package org.lucky.spring.aop.example17PointCutsNWildcards.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	//@Before("execution(public String getName())")
	//@Before("execution(public * get*())")
	//@Before("execution(public * get*())") //for method with no parameter
	//@Before("execution(public * get*(..))") //for method with 0 or more parameter
	//@Before("execution(public * get*(*))") //for method with 1 or more parameter
	//Specifying just for Circle method
	/*@Before("execution(public String org.lucky.spring.aop.example17PointCutsNWildcards.model.Circle.getName())")
	public void loggingAdvice(){
		System.out.println("Logging Advice called!!");
	}*/
	
	/*
	 * For running another advice on same pointCut use following
	 */
	@Before("allGetters()")
	public void loggingAdvice(){
		System.out.println("Logging Advice called!!");
	}
	
	@Before("allGetters()")
	public void secondAdvice(){
		System.out.println("Second Advice called!!");
	}
	
	@Pointcut("execution(public * get*())")
	public void allGetters(){}
	
	//Pointcut for all circle methods
	@Pointcut("within(org.lucky.spring.aop.example17PointCutsNWildcards.model.Circle)")
	public void allCircleMethods(){}
	
	//Advice for all getters of circle using logical operation on existing pointcuts
	@Before("allGetters() && allCircleMethods()")
	public void logicalAdvice(){
		System.out.println("Logical Advice called!!");
	}
	
	
}
