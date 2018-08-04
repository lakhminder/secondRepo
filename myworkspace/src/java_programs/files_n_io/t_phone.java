import java.io.*;
import java.util.*;

class t_phone
{
	public static void main(String a[])
	{
		int n,b,c;
		String str,str1;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList a1=new ArrayList();		
		//Integer ir=new
		try{
			while(true)
			{
			System.out.println("1.add/n 2.traverse/n 3.exit/n");
			System.out.println("enter choice");
			
			//str1=br.readLine();
                        n = Integer.parseInt(br.readLine());
			//n=br.read();
			switch(n)
			{
				case 1:
					System.out.println("enter name");
					str=br.readLine();
					a1.add(str);			
					System.out.println("enter number");
					b=Integer.parseInt(br.readLine());
					a1.add(b);
					break;
				case 2:
					System.out.println("enter name");
					str1=br.readLine();
					//a2.add(str1);
					
					Iterator itr=a1.iterator();
					while(itr.hasNext())
					{
					  //Object st1,st2;
					  String st1;
					  st1=(String)itr.next();
					  //st2=cmp.next();	
					  if(str1.equals(st1)) 
					     {
					       //System.out.println(st1);
					       //st=(String)itr.next();	
					       System.out.println(itr.next());
					     }
					  else
					     itr.next();
					}
					break;
				default:
					System.exit(0);
					break;
			//System.out.println(n);
			}
			}
		   }
		catch(Exception e)
		{
		  System.out.println("errror" + e);
		}
	}
}

