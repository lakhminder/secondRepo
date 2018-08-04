package java_programs.multithreading;
import java.applet.*;
import java.awt.*;

public class Col extends Applet implements Runnable
{
	Thread t;
	public void init()
	{
		t=new Thread(this);
		Col ob=new Col();
		System.out.println("INIT");
	}
	public void start()
	{
		t.start();
		System.out.println("START");
	}
	public void paint(Graphics g)
	{
		String msg=getParameter("name");
		g.drawString(msg,70,80);
		g.drawString("Akshay",40,20);
		g.drawRect(200,200,30,30);
	}
	public void stop()
	{
		System.out.println("STOP");
	}
	public void destroy()
	{
		System.out.println("DESTROY");
	}
	public void run()
	{
		int b=0;
		Color a[]={Color.red,Color.green,Color.magenta,Color.blue,Color.yellow};
		System.out.println("PAINT");
		try
		{
			for(b=0;b<a.length;b++)
			{
				setBackground(a[b]);
				repaint();
				Thread.sleep(1000);
				if(b==a.length-1)
				b=0;
			}
		}
		catch(Exception e)
		{
		}
	}
}