package java_programs.applet_n_swings;
/*
<applet code="A">
</applet>
*/

import java.awt.*;
import java.applet.*;

public class A extends Applet
{
	public void init()
	{
		System.out.println("Init");
	}
	public void start()
	{
		System.out.println("Start");
	}
	public void paint(Graphics g)
	{
		System.out.println("Paint");
		g.drawString("Akshay",40,20);
		setBackground(Color.cyan);
	}
	public void stop()
	{
		System.out.println("Stop");
	}
	public void destroy()
	{
		System.out.println("Destroy");
	}
}