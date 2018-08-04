package org.lucky.lambdas.eg2LambdaAsInterface;

/**
 * The BlockofCode/Lambdas type is Functional Interface i.e Interface with only one method
 * see below comments as well
 * 
 * see Greeting.java as well
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
		
		MyLambda myLambdaFunction = () -> System.out.println("Hello");
		MyAdd myAddLambdaFunction = (int a, int b) -> a+b;
		
		//Since Greeting is also a functional interface
		//Greeting greeting1 = () -> System.out.println("Hello");
		greetMain.greet(() -> System.out.println("Hello From Lambda"));
		
		//Its similar to anonymous inner classes... though a bit different
		Greeting lambdaGreeting = () -> System.out.println("Hello");
		Greeting innerClassGreeting = new Greeting(){
			@Override
			public void perform(){
				System.out.println("Hello");
			}
		};
						
		lambdaGreeting.perform();
		innerClassGreeting.perform();
		
		//Lambda as runnable for thread
		Thread thread = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("Hello");
				
			}
			
		});
		Thread myThread = new Thread(() -> System.out.println("Hello"));
		
	}
	
}

interface MyLambda{
	void foo();
}

interface MyAdd{
	int add(int x, int y);
}