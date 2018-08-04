package org.innerClassExample;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Outer outer = new Outer();
		Outer.InnerStatic innerStatic = new Outer.InnerStatic();
		Outer.InnerStatic innerStatic1 = new Outer.InnerStatic();
		innerStatic.setC(5);
		innerStatic1.printC();
	}

}
