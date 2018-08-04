

import java.io.*;
import  java.util.*;


public class UserMainCode1
{
	//Assume following return types while writing the code for this question. 
	public static String output1;


	public static void splitting_rows(String input1,String input2)
	{
		//Write code here
		System.out.println(new Date());
		output1 = "no";
		String firstChar = input2.substring(0,1);
		String temp = input1;
		ArrayList a = new ArrayList();
		int pos= 0;
		while((pos = temp.indexOf(firstChar)) > 0){
			a.add(pos);
			temp = temp.replaceFirst(firstChar, " ");
		}
		if(a.size() > 0)
		{
			for(Iterator itr = a.iterator();itr.hasNext();){
				pos = ((Integer)itr.next()).intValue();
			
			temp = input1.substring(pos) + input1.substring(0, pos) ;
			if(temp.equals(input2))
				output1 = "yes";
			break;
			}
		}
		
		System.out.println(output1);
		System.out.println(new Date());
	}	
}

