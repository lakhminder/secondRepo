package org.lucky.lambdas.eg8MethodReferences;

import java.util.Arrays;
import java.util.List;

public class PersonInitialisation {

	public static List<Person> initialize(){
		List<Person> personList = Arrays.asList(
				new Person("First","Name",60),
				new Person("Second","Last",40),
				new Person("Rohit","CName",50),
				new Person("Pandit","Tame",30),
				new Person("Anyone","Conol",80)
				);
		return personList;
	}
}
