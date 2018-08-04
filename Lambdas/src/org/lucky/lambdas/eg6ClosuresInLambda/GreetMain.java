package org.lucky.lambdas.eg6ClosuresInLambda;

import java.util.function.BiConsumer;

/**
 * A closure uses variables that are outside of the function scope. 
 * This is not a problem in traditional procedural programming – you just use the variable – 
 * but when you start producing functions at runtime it does become a problem
 * 
 * so in effect for using the variable outside scope or say inside lambda, 
 * it should be effectively final i.e it should/can't be modified
 * 
 * inner classes also deals in same way.
 * 
 * Though Java8/Lambdas are not real closures like in pure Functional Programming
 * as for this variables need to stored in heap instead of stack 
 * which is not a simple change keeping backward compatibility
 * 
 */
public class GreetMain {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 20;// till java 7 it needs to declared final to be used in inner class
		// form java 8 no need to declare final as java runtime see as effectively final
		//i.e its value is not changed in programme , so it can be used in innerclass/Lambdas
		doProcess(a, new Process() {
			
			@Override
			public void process(int i) {
				//b = b+9; // gives error => Local variable b defined in an enclosing scope must be final or effectively final
				//Since it has access to b but still can't change b, java runtime would need b as effectively final
				System.out.println(i + b);
				
			}
		});
		//b = b-8;
		//Same with Lambda
		doProcess(5, i -> System.out.println(i + b));
						
	}
	
	public static void doProcess(int i, Process p){
		p.process(i);
	}
	
	interface Process{
		void process(int i);
	}
	
	
}


