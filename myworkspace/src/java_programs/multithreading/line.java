import java.awt.*;
import java.applet.*;
//<applet code=line.class width=400 height=700></applet>
public class line extends Applet implements Runnable 
{
		Thread t=null;
		int i=10,j=20,k=30,l=40;
		public void init()
		{
			t= new Thread(this);
			t.start();
		}
		public void run()
		{
			for (; ; )
			{
				repaint();
				try
				{
					Thread.sleep(1000);
				}
				catch (Exception e)
				{
					
				}
			}
		}
		public void paint(Graphics g)
		{
			g.drawLine(i,j,k,l);
			g.drawLine(10,20,10,100);
			/*i+=10;
			j+=20;
			k+=30;
			l+=40;
			if(i==100)
			i=0;
			if(j==200)
			j=0;
			if(k==300)
			k=0;
			if(l==400)
			l=0;*/
			g.drawLine(10,20,10,200);
		}
//		System.out.println("Hello World!");
	
}
