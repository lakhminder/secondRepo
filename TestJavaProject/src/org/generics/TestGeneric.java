package org.generics;



import java.util.List;

public class TestGeneric{
	 public <T extends Number> void printList(List<T> a){
		 //a.add((Object)new Integer(12));
		 for (T t: a){
			 System.out.println(t);
		 }
	 }
}
