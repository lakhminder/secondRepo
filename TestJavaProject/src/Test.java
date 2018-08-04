import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.generics.TestGeneric;



public class Test {
private int count = 0;
	static{
		System.out.println("Static block!!");
	}
	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input1="CAPPGAFJLDHKDMJ";
		String input2="KDMJCAPPGAFJLDH";
		String input3="PGKDMPJCAAFJLDH";
		
		
		
		UserMainCode1.splitting_rows(input1, input2); 
		
	}*/
	
	/*public void test(){
		System.out.println("Inside constructor");
	}*/
	
	public static void main(String[] args) {
		/*int rowCount = 5;		
		Date date = new Date(2014, 3, 5, 0, 52);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("Time value using kk:" + sdf1.format(date));
		System.out.println("Time Value using HH:" + sdf2.format(date));
		System.out.println(rowCount);
		Parent parent = new Child();
		parent.display();*/
		
		TestGeneric test = new TestGeneric(); 
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(789);
		test.printList(a);
		List<Float> b = new ArrayList();
		b.add(5F);
		test.printList(b);
	}
	public Test() {
		System.out.println("Constructor");
	}
		

}

 class Parent{
	 static{
		System.out.println("Parent static block"); 
	 }
	 
	
	 public Parent(){
		 System.out.println("Parent constructor");
	 }
	public Parent display(){
		System.out.println("In Parent");
		return null;
	}
}
 
 class TestException{
	 int i = 0;
	 void show(){
		 if (i == 0)
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	 }
 }
 
 class Child extends Parent {
	 static{
			System.out.println("Child static block"); 
		 }
	 //@Override
	 public Parent display(){
	 //public Child display(){
		 System.out.println("Child Display");
		 return null;	 
		
	 }
	 
	 public void show(){
		 System.out.println("Inside Show");
	 }
	 
	 Child(){
		 System.out.println("Child Constructor");
		 
	 }	 
	 
 }
 
 
