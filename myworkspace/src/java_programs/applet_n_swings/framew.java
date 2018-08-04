package java_programs.applet_n_swings;
import java.awt.*;
//import java.applet.*;
import java.awt.event.*;

class framew extends Frame 
{
	framew(String title) 
	{
		super(title);
		setSize(200,200);
		setVisible(true);
		wc obj=new wc(this);
		addWindowListener(obj);
			
		
	}
	public static void main(String[] args) 
	{
		framew obj1=new framew("frame ");

		//System.out.println("Hello World!");
	}

	public void paint(Graphics g)
	{
	 	g.drawString("frame window",30,40);
		setBackground(Color.blue);
	}
}

class wc extends WindowAdapter
{
	framew f=null;
	wc(framew f1)
	{
		f=f1;

	}
	public void windowClosing(WindowEvent we)
	{
		f.setVisible(false);
	}
};
