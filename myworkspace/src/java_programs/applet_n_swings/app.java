package java_programs.applet_n_swings;
import java.awt.*;
import java.applet.*;
/* <applet code=A.class width=300 height=100></applet>*/
public class app extends Applet
{   
	public void init()
	{
		System.out.println("init");
	}

	public void start()
	{
		System.out.println("start");
		setBackground(Color.BLUE);
	}

	public void paint(Graphics g)
	{
		//System.out.println("paint");
		setBackground(Color.green);
		//g.drawString("saransh",800,600);
		
	}

	public void stop()
	{
		System.out.println("stop");
	}

	public void destroy()
	{
		System.out.println("destroy");
	}
};