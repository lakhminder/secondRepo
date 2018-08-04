

import java.io.*;
import  java.util.*;


public class UserMainCode
{
	//Assume following return types while writing the code for this question. 
	public static String output1;


	public static void splitting_rows(String input1,String input2)
	{
		//Write code here
		System.out.println(new Date());
		output1 = "no";
		int length = input1.length();
		while(length-- > 0)
		{
			if(input2.equals(input1))
				output1 = "yes";
			else{
				char c = input2.charAt(0);
				input2 = input2.substring(1) + c;
			}
		}
		System.out.println(output1);
		System.out.println(new Date());
	}	
}

