package java_programs.applet_n_swings;
import javax.swing.*;
import java.awt.*;
import java.applet.*;
//<applet code=swing.class width=400 height=400></applet>
public class swing extends JApplet
{
	JTextField tf,tf1;
	JButton bt,bt1;
	JLabel l1,l;
//	GridLayout g;
	public void init()
	{
//		g=new GridLayout(2,1);

		Container cp=getContentPane();
		cp.setLayout(null); 
		tf=new JTextField(20);
		tf.setBounds(200,10,200,30);
		bt=new JButton("ok");
		bt.setBounds(40,200,60,30);
		l=new JLabel("name");
		l.setBounds(10,10,100,30);
		l1=new JLabel("pass");
		l1.setBounds(10,60,100,30);
		tf1=new JTextField(20);
		tf1.setBounds(200,60,200,30);
		cp.add(tf);
		cp.add(l);
		cp.add(l1);
		cp.add(bt);
		cp.add(tf1);

//		bt.setSize(20,20);
	}
}
