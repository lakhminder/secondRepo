package org.lucky.lambdas.eg1;


/**
 * 1) GreetingFunction = () -> System.out.println("Hello");
 * 
 * 2) DoubleNumberFunction = (int a) -> return a*2;
 * 			return shud be removed for single line
 * 						   = (int a) -> a*2;
 * 
 * 3) AddFunction = (int a, int b) -> a+b;
 * 
 * 4) SafeDivideFunction = (int a, int b) -> {
 * 		if(b==0) 
 * 			return 0;
 * 		return a/b;
 * };
 * 
 * 5) StringLengthCountFunction = (String s) -> s.length();
 * 
 *
 */
public interface Greeting {
	
	public void perform();

}
