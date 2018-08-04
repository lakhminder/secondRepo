package org.lucky.lambdas.eg1;

/**
 * 
 * Passing behaviour as interface to greet method before java 8
 * Treat Greeting/HelloGreeting as class with an action, so in short we are passing a class which has an action
 * 
 * With Lambdas we can directly pass action/function 
 * Lambdas is a functional programming construct wherein we can use functions as values
 * 
 * convert function/method perform to lambda
 * Public void perform() {
 * 	System.out.println("Hello");
 * }
 * Steps to convert method to Lambda expression
 *1) Remove identifier i.e public as it can be accessed by whoever has it
 *2) remove name i.e perform as it will be accessed by caller variable name as say blockOfCode
 *3) remove return type i.e void as java compiler can make it out by looking at expression i.e block of code(Lambda) 
 *
 *Lambda assigned to variable(blockofCode)
 *blockofCode = () -> {
 *							System.out.println("Hello");
 * 						 }
 * 
 * if single line 
 * 4) remove the curly braces as well
 * () -> System.out.println("Hello");
 * 
 * Refer Greeting.java for more examples
 * 
 */
public class GreetMain {
	
	public void greet(Greeting greeting){
		greeting.perform();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreetMain greetMain = new GreetMain();
		HelloGreeting greeting = new HelloGreeting();
		greetMain.greet(greeting);
	}

}
