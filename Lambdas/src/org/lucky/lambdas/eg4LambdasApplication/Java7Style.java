package org.lucky.lambdas.eg4LambdasApplication;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * Input Person List
 * Tasks
 * 1) Sort by Last name
 * 2) create a method that prints all elements in list
 * 3) create a method that prints all persons that have last name beginning with 'C' 
 *
 */
public class Java7Style {

	public static void main(String a[]){
		List<Person> persons = PersonInitialisation.initialize();
		
		//Task 1
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
			
		});
		
		//Task2
		System.out.println("Printing All Persons");
		printAll(persons);
		
		//Task3 option1
		System.out.println("Printing All Persons with Last name starting with C");
		printIfLastNameBeginsWithC(persons);
		
		//Task3 option2
		//Try to pass behavior into method as this is not scalable as will end up 
		//creating methods for each different condition such as with age > 5,First name starts with A...
		//To pass condition/filter as behavior to method create condition as interface
		System.out.println("Printing All Persons with Last name starting with C");
		printConditionally(persons, new Filter(){

			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("C");					
			}
			
		});
		
		System.out.println("Printing All Persons with age > 35");
		printConditionally(persons, new Filter(){

			@Override
			public boolean test(Person p) {
				return p.getAge() > 35;			
			}
			
		});
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

}


interface Filter{
	boolean test(Person p);
}
