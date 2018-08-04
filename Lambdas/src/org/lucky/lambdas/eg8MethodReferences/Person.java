package org.lucky.lambdas.eg8MethodReferences;

public class Person {

	private String firstName;
	private String lastName;
	private int age;
	
	public Person(String firstname, String lastName, int age) {
		super();
		this.firstName = firstname;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + "]";
	}
	
	
}
