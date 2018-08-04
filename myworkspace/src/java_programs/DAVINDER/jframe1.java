package java_programs.DAVINDER;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
public class jframe1 extends JFrame implements ActionListener,Runnable
{
	Thread t=null;
	Container cp = getContentPane();
	JLabel l1,l2,l3,l4;
	JTextField t1,t3;
	JPasswordField t2;
	JButton b1,b2;
	JRadioButton r1,r2=null;
	ButtonGroup bg=null;
	JComboBox c=null;
	int count=0;
	
	jframe1()
	{
		super("window");
		
		t = new Thread(this);
		t.start();
		
		
		l1 = new JLabel("Name:");
		l2 = new JLabel("Password:");
		l3 = new JLabel("sex:");
		l4 = new JLabel("Qualification:");
		
		t1 = new JTextField(20);
		t2 = new JPasswordField();
		
		b1 = new JButton("ok");
		b2 = new JButton("cancel");
		
		r1=new JRadioButton("male");
		r2=new JRadioButton("female");
		bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		c = new JComboBox();
		c.addItem("B.E");
		c.addItem("B.SC");
		c.addItem("BTECH");
		c.addItem("XII");
		c.addItem("X");
		
//		cp.setBackground(Color.red);
		
		cp.setLayout(null); 
		cp.add(l1);
		l1.setBounds(0,0,100,30);
		
		cp.add(t1);
		t1.setBounds(100,0,100,30);
		
		cp.add(l2);
		l2.setBounds(0,50,100,30);
		
		cp.add(t2);
		t2.setBounds(100,50,100,30);
		
		cp.add(l3);
		l3.setBounds(0,100,100,30);
		
		cp.add(r1);
		r1.setBounds(100,100,80,30);
		
		cp.add(r2);
		r2.setBounds(180,100,80,30);
		
		cp.add(l4);
		l4.setBounds(0,150,100,30);
		
		cp.add(c);
		c.setBounds(100,150,100,30);
		
		cp.add(b1);
		b1.setBounds(100,300,50,50);
		
		cp.add(b2);
		b2.setBounds(180,300,90,50);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		setVisible(true);
	}
	
	
	
	
	
	public static void main(String[] args)
	{
		jframe1 jf = new jframe1();
	}
	
	public void actionPerformed(ActionEvent ae) 
	{	
		if (ae.getSource() == b1)
		{//block begin	
			boolean flag=true;
			
			char a1[]={'a','d','m','i','n'};
			char a[] = t2.getPassword();//return an arary of char
			for(int i=0;i<a1.length;i++)
			{
				if(a[i]==a1[i])
					continue;
				else 
				{
					flag=false;
					break;
				}
			}	
		}//block end
		String str = t1.getText();
		if(str.equalsIgnoreCase("Administrator"))
		{
			
			
			this.dispose();
			Password1 p= new Password1("Studentdetails");
		}
		else
		{
			t1.setText("");
			t2.setText("");
			count=count+1;
			if(count>=3)
			{
				JOptionPane.showMessageDialog(null,"Losers Outside, Intelligent Inside.","Error",JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}	 
			
		}
		
		
	}	
	
	
	public void run()
	{	
		try
		{
			Color arr[] = {Color.red,Color.green,Color.yellow,Color.pink,Color.gray,Color.blue};
			for(int i=0;i<6;i++)
			{
				
				cp.setBackground(arr[i]);
				Thread.sleep(5000);
				if (i==6)
				{
					i=0;
				}
				
			}
		}
		catch(Exception e)
		{}
	}
}



class Password1 extends JFrame implements ActionListener,ItemListener,Runnable
{
	String strg="",strc="",strfl="",strfc=""; 
	Container c;
	Thread t=null;
	JLabel name=null;
	JLabel age=null;
	JLabel add=null;
	JLabel gender=null;
	JLabel course=null;
	JLabel fac=null;
	JTextField tname=null;
	JTextField tage=null;
	JTextField tadd=null;
	JComboBox tc=null;
	JButton bok,bexit;
	JRadioButton rb1,rb2;
	JCheckBox cb1,cb2;
	Password1(String title)
	{   
		
		super(title);
		t=new Thread(this);
		t.start();
		c=getContentPane();
		c.setLayout(new GridLayout(9,2));
		name=new JLabel("Name");
		age=new JLabel("Age");
		add=new JLabel("Adress");
		gender=new JLabel("Gender");
		course=new JLabel("Course");
		fac=new JLabel("facilities");
		tname=new JTextField(30);
		tage=new JTextField(20);
		tadd=new JTextField(40);
		tc =new JComboBox();
		tc.addItem("web application designer");
		tc.addItem("database administrator");
		tc.addItem("netwok administrator");
		tc.addItem("window application developer");
		rb1=new JRadioButton("Male");
		rb2=new JRadioButton("Female");
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		cb1=new JCheckBox("library");
		cb2=new JCheckBox("computer");
		bok=new JButton("OK");
		bexit=new JButton("exit");
		c.add(name);c.add(tname);
		c.add(age);c.add(tage);
		c.add(add);c.add(tadd);
		c.add(gender);c.add(new JLabel(""));
		c.add(rb1);c.add(rb2);
		c.add(course);c.add(tc);
		c.add(fac);c.add(new JLabel(""));
		c.add(cb1);c.add(cb2);
		c.add(bok);c.add(bexit);
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bok.addActionListener(this);
		rb1.addActionListener(this);
		rb2.addActionListener(this);
		tc.addItemListener(this);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		bexit.addActionListener(this);
	}
	
	
	public static void main(String[] args)
	{
		Password1 p1 =new Password1("hello");
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bok)
		{
			if(tname.getText().equals("") || tage.getText().equals("") ||tadd.getText().equals("") || strg.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Fields are empty,so plz Fuck off","Error",JOptionPane.ERROR_MESSAGE );
				
			}
			else
			{
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection c=DriverManager.getConnection("jdbc:odbc:dsn");
					Statement s= c.createStatement();
					int agee=Integer.parseInt(tage.getText());//convert age(string value)to int value
					int i=s.executeUpdate("insert into data values('"+tname.getText()+"',"+agee+",'"+tadd.getText()+"','"+strg+"','"+strc+"','"+strfl+' '+strfc+"')");
					JOptionPane.showMessageDialog(null,"Data has been successfully placed in database","Success",JOptionPane.PLAIN_MESSAGE );
					tname.setText("");
					tage.setText("");
					tadd.setText("");
					s.close();
					c.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			
			
		}
		if(ae.getSource()==rb1)
		{
			strg=rb1.getText();//get text from textfield
		}
		if(ae.getSource()==rb2)
		{
			strg=rb2.getText();//get text from textfield
		}
		if(ae.getSource()==bexit)
			System.exit(0);
		
	}
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==tc)
		{
			strc=tc.getSelectedItem().toString();//get text from combobox
		}
		if(ie.getSource()==cb1)
		{
			strfl=cb1.getText();// get text from checkbox
		}
		if(ie.getSource()==cb2)
		{
			strfc=cb2.getText();//get text from checkbox
		}
		
		
	}
	
	
	
	public void run()
	{	
		try
		{
			Color arr[] = {Color.red,Color.green,Color.yellow,Color.pink,Color.gray,Color.blue};
			for(int i=0;i<6;i++)
			{
				
				c.setBackground(arr[i]);
				Thread.sleep(5000);
				if (i==6)
				{
					i=0;
				}
				
			}
		}
		catch(Exception e)
		{}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}



