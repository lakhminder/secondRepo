import java.io.*;
import java.util.*;

class bank
	static int accno=1;
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
			System.out.println("1.open account\n 2.deposit\n 3.withdrawl\n 4.check\n5.exit");
			System.out.println("enter choice");
			
			//str1=br.readLine();
                        n = Integer.parseInt(br.readLine());
			//n=br.read();
			switch(n)
			{
				case 1:
					a1.add(accno++);
					//System.out.println("enter name");
					//str=br.readLine();
					a1.add(0);
					//System.out.println("account created");			
					break;
				case 2:
					System.out.println("enter accno");
				        n=Integer.parseInt(br.readLine());
					//str1=br.readLine();
					Iterator itr=a1.iterator();
					while(itr.hasNext())
					{
					  String st1;
					  st1=(String)itr.next();
					  if(st1==str1)
					     {
					       System.out.println(st1);
					       //st=(String)itr.next();	
					       System.out.println(itr.next());
					      }
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