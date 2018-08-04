package org.lucky.lambdas.eg8MethodReferences;

/**
 * 
 * Method reference can be used for Lambdas whereever its a simple pass through
 * i.e input parameters are simply being passed to method invoked from Lambda
 * 
 * eg () -> method()
 * (a) -> method(a)
 * 
 * className::MethodName (incase of static method)
 * or
 * Object::methodName (incase of instance method)
 *
 */
public class MethodReferenceMain {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> sayHello());
		thread.start();

		//Using Method Reference
		Thread thread1 = new Thread(MethodReferenceMain::sayHello);
		thread1.start();
	}
	
	public static void sayHello(){
		System.out.println(Thread.currentThread().getName() + "Hello");
	}

}
