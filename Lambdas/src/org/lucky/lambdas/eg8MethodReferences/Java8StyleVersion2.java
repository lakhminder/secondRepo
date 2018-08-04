package org.lucky.lambdas.eg8MethodReferences;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 
 * see MethodReferenceMain
 */
public class Java8StyleVersion2 {

	public static void main(String a[]){
		List<Person> persons = PersonInitialisation.initialize();
		
		
		System.out.println("Printing All Persons with age > 35");		
		//performConditionally1(persons, p -> p.getAge() > 35, p-> System.out.println(p));
		//Using method reference
		// (p) -> method(p) Java automatically passes the parameter as it infers from Consumer
		performConditionally1(persons, p -> p.getAge() > 35, System.out::println);
	}
	
	
	/**
	 * So it takes 3rd parameter as perform behavior(print) as lambda
	 * It uses Consumer<T>
	 */
	public static void performConditionally1(List<Person> persons, Predicate<Person> filter, Consumer<Person> consumer){
		for(Person p : persons){
			if(filter.test(p))
				consumer.accept(p);
		}
	}

}

