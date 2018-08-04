import java.util.*;
import java.io.*;
import java.applet.*;
import java.awt.*;
public class syn1 extends Applet implements Runnable
{      //class begin
 
 Thread t,t1;
 Vector a1 ;
 //ArrayList al = new ArrayList();
// int y =100;
String str1,str;
int k=0;
//Graphics g =getGraphics();
public void init()
{
t = new Thread(this,"ist");
t1= new Thread(this,"second");
t.start();
t1.start();

a1= new Vector();
}

public void start()
{	
setBackground(Color.red);
}
public void run()
	{		//run begin
	synchronized(this)
			{ //syn begin 
			Thread curr =Thread.currentThread();
				if(curr.getName().equals("ist"))
				{
					for( k=0;k<2;k++)
					{
					Scanner sc =new Scanner(System.in);
					System.out.println("Enter the shape");
					a1.addElement(sc.nextLine());
					System.out.println("output String:"+ str);
					
					}
				   }
			
				else 
					{

					System.out.println("current thread:"+ curr.getName());
					repaint();						
					}//else end
				}//syn end
		}//run end

			public void paint(Graphics g)
			{
			    	Iterator itr = a1.iterator();
		              	while(itr.hasNext())
						{  
						  try
						  {
						  Thread.sleep(1000);
						  }
						  catch(Exception e)
						  {
						  e.printStackTrace();
						  }
						 str1=(String)itr.next();

							if(str1.equals("oval"))
							{
							g.setColor(Color.blue);
							g.drawOval(80,80,100,100);
							}
						
							else if(str1.equals("rectangle"))
							{
							g.setColor(Color.red);
							g.fillRect(10,10,300,300);
							g.setColor(Color.blue);
							g.drawRect(80,80,100,100);
								}
						}	
			      }





	}

	//<applet code = syn1.java width=400 height=400> </applet>