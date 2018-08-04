package java_programs.multithreading;
import java.awt.*;
import java.applet.*;
import java.util.*;
import java.io.*;
public class sync extends Applet implements Runnable 
{	
	
	Thread t,t1,curr;
	//Scanner sc=new Scanner(System.in);
	BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
	//Vector v=new Vector();
	ArrayList a1=new ArrayList();
	String s1,s2;
	//Graphics g=getGraphics();
	 int i=20;
	 Iterator itr;
	
	public void init()
	{
		t=new Thread(this,"first");
		t1=new Thread(this,"second");
		t.start();
		//t.setPriority(7);
		t1.start();
	}

	public void paint(Graphics g)
	{	
		System.out.println(a1);
		itr=a1.iterator();
		while (itr.hasNext())
		{
			s2=(String)itr.next();
						//g.drawString(s2,100,i++);	
				if(s2.equals("rectangle"))
				{
					g.drawRect(50,50,150,150);
				}
				if(s2.equals("oval"))
				{
					g.drawOval(300,200,100,100);
				}
				if(s2.equals("line"))
				{
					g.drawLine(300,200,100,100);
				}
		//g.drawString(s2,100,i);
		//i=i+30;
				try
				{
					
					Thread.sleep(1000);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		}
	}
	public void run()
	{	
		try
		{
			
			synchronized(this)
			{
				curr=Thread.currentThread();
				s1=(String)curr.getName();
				System.out.println(s1);
				if(s1.equals("first"))
				{
					System.out.println("enter string");
					String str=sc.readLine();
					a1.add(str);
					System.out.println("enter 2nd string");
					str=sc.readLine();
					a1.add(str);
					System.out.println("enter 3rd string");
					str=sc.readLine();
					a1.add(str);
				}
				else
				{
					while(true)
					repaint();
				
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
}
//<applet code=sync.class width=500 height=500></applet>