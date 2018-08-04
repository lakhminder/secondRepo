import java.awt.*;
import java.applet.*;

public class ch_app extends Applet implements Runnable
{
	public void init()
	{
		Thread t=new Thread(this);
		t.start();		
	}

	public void run() 
	{	
		try
		{
		Color arr[]={Color.blue,Color.white,Color.green,Color.red};
		for (int i=0;i<=arr.length ;i++ )
		{
			setBackground(arr[i]);
			Thread.sleep(1000);
			if(i==3) 
				{
					i=0;
				}
		}
		}
		catch(Exception e)
		{System.out.println("errror" + e );
		}
		
	}
}

//<applet code=ch_app.class width=100 height=200></applet>