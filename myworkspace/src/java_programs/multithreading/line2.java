import java.awt.*;
import java.applet.*;

public class line2 extends Applet implements Runnable
{
			Graphics g;
	public void init()
	{

		Thread t=new Thread(this);
		t.start();		
	}

	public void run() 
	{	
		try
		{
			
			/*public void paint(Graphics g)
			{
				while(true) 
				{
				g.drawLine(10,10,10,60);
				Thread.sleep(1000);
				g.drawLine(10,10,10,100);
				Thread.sleep(1000);
				}
			}*/
				while (true)
				{
				
				g.drawLine(10,10,10,60);
				Thread.sleep(1000);
				g.drawLine(10,10,10,100);
				Thread.sleep(1000);
				}
		}
		catch(Exception e)
		{System.out.println("errror" + e );
		}
		
	}
}

//<applet code=line.class width=100 height=200></applet>