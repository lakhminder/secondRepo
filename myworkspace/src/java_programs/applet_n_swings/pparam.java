package java_programs.applet_n_swings;
/*
<applet code=pparam.class width=400 height=300>
<param name=font value=newtimesroman>
</applet>
*/
import java.awt.*;
import java.applet.*;

public class pparam extends Applet 
{
	public void paint(Graphics g)
	{
		//System.out.println("paint");
		//setBackground(Color.BLUE);

		String msg=getParameter("font");
		g.drawString(msg,200,100);		
	}
}
