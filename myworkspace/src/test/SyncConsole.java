package test;
import java.io.*;
import java.util.*;
class SyncConsole 
{
	
	public static void main(String arg[])
	{		
		UserInfo ui=new UserInfo();
		Thread t1=new Thread(ui,"other");		
		t1.start();
		synchronized(ui)
		{
			System.out.println("waiting for user to feed data");
			try
			{
				while(true)
				{
					if(ui.lt.isEmpty())//must wait till the event on which it is waiting shall happen
					{
						ui.wait();					
					}
					System.out.println("first string entered was:" + ui.lt.remove(0));
					System.out.println("second string entered was:" + ui.lt.remove(0));
					System.out.println("third string entered was:" + ui.lt.remove(0));
				}
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}

class UserInfo implements Runnable
{
	String str1=null,str2=null,str3=null; 
	ArrayList lt=new ArrayList();
	BufferedReader br;
	public void run()
	{
		while(true)
		{
			synchronized(this)//as operation of taking the data is atomic
			{
				
				try
				{
					lt.removeAll(lt);
					br=new BufferedReader(new InputStreamReader(System.in));
					System.out.print("/nenter first string to be displayed:");			
					str1=br.readLine();
					lt.add(str1);
					System.out.print("/nenter second string to be displayed:");			
					str2=br.readLine();
					lt.add(str2);
					System.out.print("/nenter third string to be displayed:");		
					str3=br.readLine();
					lt.add(str3);					
					notifyAll();
					Thread.sleep(1000);//As notify releases the lock after sometime
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}