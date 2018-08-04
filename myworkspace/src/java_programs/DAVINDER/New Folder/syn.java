import java.util.*;
import java.io.*;
import java.applet.*;
import java.awt.*;

public class syn extends Applet implements Runnable
{//class begin
 Thread t,t1;
 Vector v = new Vector();
 int y =100;
 Graphics g = getGraphics();
//public void init()
//{

//}

public void start()
{	
t = new Thread(this,"ist");
t1= new Thread(this,"second");
t.start();
t1.start();
}


public void run()
	{//run begin
	try
		{//try begin
	synchronized (this)
			{ //syn begin 

		
	Thread curr = Thread.currentThread();
	if(curr.getName().equals("ist"))
			{
				for(int k=0;k<2;k++)
				{
				Scanner sc =new Scanner(System.in);
				System.out.println("Enter the shape");
				String str = sc.nextLine();
				System.out.println("output String:"+ str);
				v.addElement(str);
				}
			}
					else 
					{
					System.out.println("current thread:"+ curr.getName());
					
					Iterator itr = v.iterator();

						while(itr.hasNext())
						{   //while begin
						String str1=(String)itr.next();
							if(str1.equalsIgnoreCase("oval")
							{
							g.drawOval(str1,100,y);
							y=y+20;
							}
								if(str1.equalsIgnoreCase("rectangle")
								{
								g.drawRectangle(str1,150,y);
								y=y+20;
								}
						}//while end
				}
		}//try end
		catch(Exception e)
		{}

}
}
//<applet code = syn.java width=400 height=400> </applet>