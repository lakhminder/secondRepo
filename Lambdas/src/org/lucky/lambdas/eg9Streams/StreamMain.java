package org.lucky.lambdas.eg9Streams;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Java 8 provides internal iteration(forEach method on each collection) to work with Streams
 * forEach takes a Consumer(Functional Interface i.e Consumer<? super T> action)
 * 
 *Stream has three parts
 *1) source i.e some collection
 *2) operations like Filter
 *3) Terminal operation like forEach/count
 *
 *Streams only get started once it sees a terminal operation
 *
 *Stream can possible generate parallel processing using parallelStream()
 */
public class StreamMain {

	public static void main(String[] args) {
		List<Person> persons = PersonInitialisation.initialize();
		
		//to print 
		//persons.forEach(p -> System.out.println(p));
		
		persons
		//.stream()
		.parallelStream()
		.filter(p->p.getLastName().startsWith("C"))
		.forEach(System.out::println);
		
		
		//To get min
		System.out.println(persons.stream().min((a,b) -> a.getAge() - b.getAge()).orElse(null));

	}

}
