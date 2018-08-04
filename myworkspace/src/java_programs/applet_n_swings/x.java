package java_programs.applet_n_swings;
import java.awt.*;
import java.applet.*;
/*
<applet code="x.java" width=100 height=100></applet>
*/
public class x extends Applet 
{
//	public static void main(String[] args) 
	public void start()
	{
		System.out.println("start");
	}
		public void init()
	{
		System.out.println("init");
	}
	public void paint(Graphics g)
	{
		//System.out.println("start");
		g.drawString("applet",100,50);
		setBackground(Color.blue);

		//setColor(100,200,0);

	}
	public void stop()
	{
		System.out.println("stop");
	}

}
