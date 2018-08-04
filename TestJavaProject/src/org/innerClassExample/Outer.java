package org.innerClassExample;

public class Outer {
	int a;
	
	public static class InnerStatic{
		int c =3;
		
		public void setC(int c){
			System.out.println("c was:" + this.c);
			this.c = c;
			System.out.println("c is:" + this.c);
		}
		
		public void printC(){
			//System.out.println(c + a);  // not possible
			System.out.println(c);
		}
	}
	
	public class Inner{
		int b = 2 + a;
	}

}
