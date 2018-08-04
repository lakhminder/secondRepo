package java_programs.applet_n_swings;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="Ex" width="250" height="250">
</applet>
*/
public class Ex extends Applet
{
	Frame f=null;
	public void init()
	{
		f=new Frame1("Frame Window");
		f.setSize(250,250);
		f.setVisible(true);
	}

	public void start()
	{
		f.setVisible(true);
	}

	public void stop()
	{
		f.setVisible(false);
	}

	public void paint(Graphics g)
	{
		g.drawString("HAILOSSSS",200,60);
	}
}

class Frame1 extends Frame
{
	Frame1 f=null;
	Frame1(String t)
	{
		super(t);
		ad my=new ad(this);
		addWindowListener(my);
	}

	public void paint(Graphics g)
	{
		g.drawString("window",10,40);
	}
}

class ad extends WindowAdapter
{
	Frame1 f1;
	ad(Frame1 f2)
	{
		f1=f2;
	}

	public void windowClosing(WindowEvent we)
	{
		f1.setVisible(false);
	}
}