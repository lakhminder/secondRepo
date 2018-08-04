package java_programs.applet_n_swings;
import java.applet.*;
import java.awt.*;

public class Line extends Applet implements Runnable
{
	int i=40,j=20,k=40,l=20;
	Thread t=null;
	public void init()
	{
		Line l=new Line();
		t=new Thread(this);
	}
	public void start()
	{
		t.start();
	}
	public void paint(Graphics g)
	{
		g.drawLine(i,j,k,l);
		g.drawLine(j,l,k,i);
		g.drawLine(k,i,l,j);
		g.drawLine(j,i,l,k);
		i+=10;
		j+=10;
		k+=10;
		l+=10;
		if(i==100) i=0;
		if(j==200) j=0;
		if(k==300) k=0;
		if(l==400) l=0;
	}
	public void run()
	{
		int b=0;
		Color a[]={Color.red,Color.green,Color.magenta,Color.blue,Color.yellow,Color.pink};
		for(;;)
		{
			repaint();
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
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{
			}
		}
	}
}