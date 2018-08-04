package java_programs.applet_n_swings;

//<applet code=but.class width=400 height=400></applet>
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.io.*;

public class  but extends Applet implements ActionListener
{
	Button b;
	Label name,pass;
	TextField nm,ps;
	String str=null,str1=null,str3=null,str2=null;
	public void init() 
	{
//		Container cp=getContentPane();
		setLayout(null);
		b=new Button("ok");
		name=new Label("name");
		name.setBounds(0,10,100,30);
		//add(name);
		pass=new Label("pass");
		pass.setBounds(0,50,100,30);
		nm=new TextField(20);
		nm.setBounds(110,10,100,30);
		//nm.addActionListener(this);
		ps=new TextField(30);
		ps.setEchoChar('*');
		ps.setBounds(110,50,100,30);
		add(name);
		add(nm);
		add(pass);
		add(ps);
		add(b);
		b.addActionListener(this);
		b.setBounds(10,100,100,30);
		//str=nm.getText();
	}

	public void paint(Graphics g) 
	{
		str=nm.getText();
		str1=b.getLabel();
		str3=ps.getText();
		if (str2.equals("ok") && !str.equals("") && !str3.equals(""))
		{
			
			g.drawString(str,200,300);
			//repaint();
			g.drawString(str1,100,200);
			nm.setText("");
			ps.setText("");
			
		}
		else
		{	
			//OptionPane.showMessageDialog(null,"cannot be null","Success",OptionPane.PLAIN_MESSAGE );
			g.drawString("null not allowed",300,300);
			nm.setText("");
			ps.setText("");
			
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		str2=ae.getActionCommand();
		repaint();
		
	}
}
