package java_programs.applet_n_swings;
//<applet code=evnt.class width=400 height=400></applet>
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class  evnt extends Applet implements ActionListener
{
	Button b;
	Label name,pass;
	TextField nm,ps;
	String str,str1;
	public void init() 
	{
		b=new Button("ok");
		
		name=new Label("name");
		
		

		pass=new Label("pass");
		
		nm=new TextField();
		nm.addActionListener(this);
		ps=new TextField();
		ps.setEchoChar('*');
		add(name);
		add(nm);
		add(pass);
		add(ps);
		add(b);
		b.addActionListener(this);
		//str=nm.getText();
	}

	public void paint(Graphics g) 
	{
		//repaint();
		str1=b.getLabel();
		//g.drawString(str1,100,200);
		if(str1.equals("ok")) 
		{
		str=nm.getText();
		g.drawString(str,200,300);
		
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		repaint();
		
	}
}
