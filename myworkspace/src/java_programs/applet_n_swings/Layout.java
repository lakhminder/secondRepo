package java_programs.applet_n_swings;
import java.awt.event.*;
import java.applet.*;
import java.awt.*;
import java.util.*;

public class Layout extends Applet implements ActionListener
{
	TextField t1=null;
	TextField t2=null;
	Button b=null;
	Button b1=null;
	String msg="";
	int i=40,j=50;
	ArrayList a=new ArrayList();
	//GridLayout g=new GridLayout(3,2);
	public void init()
	{
		//setLayout(g);
        setBackground(Color.blue);
		Label l1=new Label("Name");
		t1=new TextField(10);
		Label l2=new Label("Password");
		t2=new TextField(10);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		t2.setEchoChar('*');
		b=new Button("OK");
		b1=new Button("Cancel");
		add(b);
		add(b1);
		t1.addActionListener(this);
		t2.addActionListener(this);
        b.addActionListener(this);
		b1.addActionListener(this);
	}
	public void paint(Graphics g)
	{
		g.drawString(msg,i,j);
		j+=10;
		if(j==100)
		j=50;
		//g.drawString(str[1],40,90);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b)
		{
			if(t1.getText().equals("") || t2.getText().equals(""))
			{
				msg="Fields can't be left blank";
				repaint();
			}
			else
			{
				a.add(t1.getText());
				t1.setText("");
				a.add(t2.getText());
				t2.setText("");
				msg="";
				repaint();
			}
		}
		else if(ae.getSource()==b1)
		{
			t1.setText("");
			t2.setText("");
		}
		//repaint();
	}
	public void destroy()
	{
		Iterator i=a.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
	}
}