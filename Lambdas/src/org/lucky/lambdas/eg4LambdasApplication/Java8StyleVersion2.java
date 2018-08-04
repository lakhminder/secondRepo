package org.lucky.lambdas.eg4LambdasApplication;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 
 * Input Person List
 * Tasks
 * 1) Sort by Last name
 * 2) create a method that prints all elements in list
 * 3) create a method that prints all persons that have last name beginning with 'C' 
 *
 * Pass the behavior for both filter/condition(done in java8Style) behavior and print(done here) behavior
 * look performConditionally1() 
 */
public class Java8StyleVersion2 {

	public static void main(String a[]){
		List<Person> persons = PersonInitialisation.initialize();
		
		//Task 1
		//Collections.sort(persons, (Person p1, Person p2) -> p1.getLastName().compareTo(p2.getLastName()));
		//With type inference
		Collections.sort(persons, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		//Task2
		System.out.println("Printing All Persons");
		printAll(persons);
		//printConditionally(persons, p -> true);
		
		//Task3 option1
		System.out.println("Printing All Persons with Last name starting with C");
		printIfLastNameBeginsWithC(persons);
		
		//Task3 option2
		//Try to pass behavior into method as this is not scalable as will end up 
		//creating methods for each different condition such as with age > 5,First name starts with A...
		//To pass condition/filter as behavior to method create condition as interface
		System.out.println("Printing All Persons with Last name starting with C");
		printConditionally(persons, p -> p.getLastName().startsWith("C"));
		performConditionally1(persons, p -> p.getLastName().startsWith("C"), p-> System.out.println(p));
		
		System.out.println("Printing All Persons with age > 35");
		printConditionally(persons, p -> p.getAge() > 35);
		//printConditionally1(persons, p -> p.getAge() > 35);
		performConditionally1(persons, p -> p.getAge() > 35, p-> System.out.println(p));
	}
	
	//Task2
	public static void printAll(List<Person> persons){
		for(Person p : persons){
			System.out.println(p);
		}
	}
	
	//Task3 option1
	public static void printIfLastNameBeginsWithC(List<Person> persons){
		for(Person p : persons){
			if(p.getLastName().startsWith("C"))
				System.out.println(p);
		}
	}
	
	//Task3 option2
	public static void printConditionally(List<Person> persons, Filter filter){
		for(Person p : persons){
			if(filter.test(p))
				System.out.println(p);
		}
	}
	
	//Task3 option2 Java 8 specific
	//Java 8 provides some out-of-the-box functional interfaces that lets us write some lambda expressions without having to declare an interface first
	//Notice Predicate from java.util.function
	//So java8 provides some Functional interfaces out of box.. eg Predicate<T>, Function<T,R>  , Supplier<T>
	//which are generic so can be used easily with our types like below
		/*public static void printConditionally1(List<Person> persons, Predicate<Person> filter){
			for(Person p : persons){
				if(filter.test(p))
					System.out.println(p);
			}
		}*/
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

//Already created in Java7Style.java
/*interface Filter{
	boolean test(Person p);
}*/
