import java.awt.*;
import java.applet.*;


public class ball extends Applet implements Runnable
{
	int i,j,k,l;
    Thread t=null;
public void init()
	{  
		System.out.println("applet started");
		setBackground(Color.black);
		}

public void start()
	{
		t=new Thread(this);
		t.start();
	}

public void run()
	{	
		i=10;
		j=390;
		k=10;
		l=390;
		Graphics g = getGraphics();
				
		while(true)
			{
		g.setColor(Color.red);
		g.drawOval(i,k,80,80);
		g.fillOval(i,k,80,80);

		g.setColor(Color.blue);
		g.drawOval(i,l,80,80);
		g.fillOval(i,l,80,80);

		g.setColor(Color.green);
		g.drawOval(j,k,80,80);
		g.fillOval(j,k,80,80);

		g.setColor(Color.orange);
		g.drawOval(j,l,80,80);
		g.fillOval(j,l,80,80);
		
		try
		{
			t.sleep(1000);
		}
		catch (Exception e)
		{
		}
	
		g.setColor(Color.black);
		g.drawOval(i,k,80,80);
		g.fillOval(i,k,80,80);

		g.setColor(Color.black);
		g.drawOval(i,l,80,80);
		g.fillOval(i,l,80,80);

		g.setColor(Color.black);
		g.drawOval(j,k,80,80);
		g.fillOval(j,k,80,80);

		g.setColor(Color.black);
		g.drawOval(j,l,80,80);
		g.fillOval(j,l,80,80);

		i=i+10;
		j=j-10;
		k=k+10;
		l=l-10;
		
		if (i==200||j==200||k==200||l==200)
		{

		i=10;
		j=390;
		k=10;
		l=390;


		}
			}
	}		

};
//<applet code = ball.class width=500 height=500></applet>