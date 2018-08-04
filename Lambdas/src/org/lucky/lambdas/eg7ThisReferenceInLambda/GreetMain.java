package org.lucky.lambdas.eg7ThisReferenceInLambda;

import java.util.function.BiConsumer;

/**
 * Difference b/w Anonymous inner class and Lambdas
 * 
 * this reference in inner class refers to the anonymous inner class object
 * whereas this in Lambda refers to same context as if declared outside lambda
 * 
 * So in effect inner class overrides this reference whereas Lambdas don't
 * So you can't use this in Lambdas invoked in static method
 * 
 * 
 */
public class GreetMain {
	
	public static void main(String[] args) {
		GreetMain greetMain = new GreetMain();		
		
		//Using inner class
		greetMain.doTest(10, new TestReference() {
			
			@Override
			public void test(int i) {
				System.out.println(this);
				
			}
			
			@Override
			public String toString(){
				return "Inner Instance called";
			}
		});
		
		//Using Lambda from static context
		//System.out.println(this);// Error => Cannot use this in a static context
		//greetMain.doTest(10, i -> System.out.println(this)); // Error => Cannot use this in a static context
		
		
		//using Lambda from instance
		greetMain.invokeLambdaFromInstance();
	}
	
	public void doTest(int i, TestReference tr){
		tr.test(i);
	}
	
	public void invokeLambdaFromInstance(){
		//System.out.println(this);//Works Fine
		doTest(10, i -> System.out.println(this));
	}
	
	@Override
	public String toString(){
		return "GreetMain Instance called";
	}
}


