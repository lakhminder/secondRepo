import java.awt.*;
import java.awt.applet.*;
import java.util.*;

class Marquee extends Applet implements Runnable
{
	Thread t;
	int i;
	public void start()
		{
		t=new Thread(this);
		t.start();
		}
	public void run()
		{
			
		try{
		for (int i=0;i<=200 ;i++)
				{
				repaint();
				Graphics g=getGraphics();
				
				g.drawString("Marquee String Going On",150,i);
				}
			
			
		
		

			t.sleep(500);

		}

		catch(Exception e)
			{
			}

	}
	public static void main(String args[])
		{
			Thread t1=new Thread();
			try
			{
			for(;;)
			t1.sleep(100);
			}
			catch(Exception e)
			{}
		}	

}