package org.lucky.lambdas.eg5LambdaExceptions;

import java.util.function.BiConsumer;

/**
 * 
 * Given an array and key, say we have to perform the operation on all
 * members of array with that key
 * 
 * This behavior can be passed as an Lambda and then we need to handle Exception in case any be
 * 
 * Functional Interface 
 * BiConsumer<T, U> has a method 
 * void accept(T,U)
 * 
 * For Exception handling
 * 1) you can do it in callee i.e process()
 * 2) you can do in caller i.e inside Lambda itself see below
 * 3) write a wrapper Lambda to do Exception Handling
 */
public class GreetMain {
	
	public static void main(String[] args) {
		int [] memberArray = {5,8,0,6};
		int key = 5;//0
				
		//process(memberArray, key,(a, b) -> System.out.println(a/b));
		// 2) With Exception handling
		/*process(memberArray, key,(a, b) -> {
			try{
				System.out.println(a/b);
			}catch(ArithmeticException e){
				System.out.println("Exception while operating" + a + "and " + b);
			}
		});*/
		
		//3
		process(memberArray, key, wrapperLambda((a, b) -> System.out.println(a/b)));
						
	}
	
	private static void process(int[] memberArray, int key, BiConsumer<Integer, Integer> consumer){
		for(int i : memberArray){
			consumer.accept(key, i);
			//1 Exception handling
			/*try{
				consumer.accept(key, i);
			}catch(ArithmeticException e){
				System.out.println("Exception while operating" + key + "and " + i);
			}*/
		}
	}
	
	//It can be made Generic as well instead of Integer
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
		return (k,v) ->{
			try{
				consumer.accept(k, v);
			}
			catch(ArithmeticException e){
				System.out.println("Exception in Wrapper while operating " + k + "and " + v);
			}
			
		};
	}
}


