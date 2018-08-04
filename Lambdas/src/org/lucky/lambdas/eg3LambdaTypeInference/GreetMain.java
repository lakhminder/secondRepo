package org.lucky.lambdas.eg3LambdaTypeInference;

/**
 * 
 * see below comments 
 * 
 */
public class GreetMain {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		MyLambda myLambdaFunction = () -> System.out.println("Hello");
		
						
			
		MyStringLengthLambda stringLenth = (String s) -> s.length();
		//1) With Type inference java compiler can deduce the parameter types by seeing the target lambda interface
		MyStringLengthLambda stringLenth1 = (s) -> s.length();
		//2) since one parameter, remove paranthesis()
		MyStringLengthLambda stringLenth2 = s -> s.length();
		
		MyAdd myAddLambdaFunction = (int a, int b) -> a+b;
		MyAdd myAddLambda = (a, b) -> a+b;
		
		
	}
	
}

interface MyLambda{
	void foo();
}

interface MyAdd{
	int add(int x, int y);
}

interface MyStringLengthLambda{
	int getLength(String str);
}
