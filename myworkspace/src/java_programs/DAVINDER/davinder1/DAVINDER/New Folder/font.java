import java.applet.*;
import java.awt.*;
public class font extends Applet implements Runnable
{
	Thread t;
	Font f;
	//String str ="this is text";
	int i=10;
	public void init()
	{
	System.out.println("applet started");
	//setBackground(Color.red);
	}
	public void start()
		{	
			t = new Thread(this);
			t.start();
		
		}

		public void run()
			{
			//Graphics g = getGraphics();
			
			for(i=10;i>100;i++)
			{	
				Graphics g = getGraphics();
				try
					{
						
					//f = new Font("Arial",Font.BOLD,i);
					//g.setFont(f);
					g.setColor(Color.red);
					g.drawString("helo",100,100);
					Thread.sleep(100);
					if (i==100)
						{
						i=10;
						}
					}
					catch(Exception e)
					{}
			}
			}
		

};
//<applet code= font.class width = 400 height = 400> </applet>