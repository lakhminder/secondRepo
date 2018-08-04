import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
public class jframedb extends JFrame implements ActionListener
{
public  static int s;
Container cp = getContentPane();
JLabel l1;
JTextField t1;
JButton b1;


	jframedb()
	{
	super("window");
	l1 = new JLabel("Emp id");

	t1 = new JTextField(20);

	b1 = new JButton("ok");

	setLayout(null); 
	cp.add(l1);
	l1.setBounds(0,0,100,30);

	cp.add(t1);
	t1.setBounds(100,0,100,30);

	cp.add(b1);
	b1.setBounds(100,100,50,50);

	b1.addActionListener(this);
	setDefaultLookAndFeelDecorated(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(250,200);
	setVisible(true);

}//constructor end

public void actionPerformed(ActionEvent ae)
{	
int flag=0;
	try
	{
	 if (ae.getSource()==b1 && !t1.getText().equals(""))
	 {	
		s= Integer.parseInt(t1.getText());
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:odbc:employee");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from empdata");
			while(rs.next())
			{
				if (s==rs.getInt(1))//check uniqueness
				{
				JOptionPane.showMessageDialog(null,"Record already exists");
				t1.setText("");
				flag=1;
				break;
				}
			}
			
		//int j= st.executeUpdate("insert into empdata(empid) values(s)");
		if (flag==0)
		{
		st.close();
		con.close();
		this.dispose();
		jframedb1 db1 = new jframedb1(s);
		}

	}
	else
		JOptionPane.showMessageDialog(null,"Null not Allowed");
	
	}//try end
	catch(Exception e)
	{}
 
}





public static void main(String[] args)
{
jframedb db = new jframedb();


}


}//class end






 class jframedb1 extends JFrame implements ActionListener
{
Container cp = getContentPane();
JLabel L1,L2,L3,L4;
JTextField T1,T2,T3;
JButton B1,B2;



	jframedb1(int x)
	{
	super("window2");
	L1 = new JLabel("Emp id");
	L2 = new JLabel("Name");
	L3 = new JLabel("Age");


	T1 = new JTextField(20);
	T2 = new JTextField(20);
	T3 = new JTextField(20);

	B1 = new JButton("Add");
	B2 = new JButton("Search");

	setLayout(null); 
	cp.add(L1);
	L1.setBounds(0,0,100,30);

	cp.add(T1);
	T1.setBounds(100,0,100,30);
	
	
	cp.add(L2);
	L2.setBounds(0,60,100,30);

	cp.add(T2);
	T2.setBounds(100,60,100,30);


	cp.add(L3);
	L3.setBounds(0,120,100,30);

	cp.add(T3);
	T3.setBounds(100,120,100,30);



	cp.add(B1);
	B1.setBounds(0,200,100,50);

	cp.add(B2);
	B2.setBounds(150,200,100,50);

	B1.addActionListener(this);
	B2.addActionListener(this);
	setDefaultLookAndFeelDecorated(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(500,500);
	setVisible(true);
	T1.setText(""+x);
	T1.setEnabled(false);
	}








//public static void main(String[] args)
//{
//jframedb1 db2 = new jframedb1();


public void actionPerformed(ActionEvent ae)
{
	try
	{
if (ae.getSource()==B1&& !T2.getText().equals("") && !T2.getText().equals(""))
{
	String s1 = T2.getText();
	int s2 =Integer.parseInt(T3.getText());
	int s3 = Integer.parseInt(T1.getText());
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con = DriverManager.getConnection("jdbc:odbc:employee");
	Statement st = con.createStatement();
	//ResultSet rs = st.executeQuery("select * from empdata");
	int j= st.executeUpdate("insert into empdata values("+s3+",'"+s1+"',"+s2+")");
	T1.setText("");
	T2.setText("");
	T3.setText("");
	st.close();
	con.close();
	this.dispose();
	jframedb db = new jframedb();

}//if end
	else if (ae.getSource()==B2)
	{
	this.dispose();
	search se = new search();
	

	}



}//tryend
catch(Exception e)
{}



}





};//class end2


class search extends JFrame implements ActionListener
{
	
Container cp = getContentPane();
JLabel L1,L2,L3;
JTextField T1,T2,T3;
JButton B1;




	search()
	{
	super("window");
	L1 = new JLabel("Enter Empid");
	L2 = new JLabel("Name");
	L3 = new JLabel("Age");


	T1 = new JTextField(20);
	T2 = new JTextField(20);
	T3 = new JTextField(20);

	B1 = new JButton("Display");

	setLayout(null); 

	cp.add(L1);
	L1.setBounds(0,0,100,30);

	cp.add(T1);
	T1.setBounds(100,0,100,30);
	
	
	//cp.add(L2);
	//L2.setBounds(0,60,100,30);

	//cp.add(T2);
	//T2.setBounds(100,60,100,30);


	//cp.add(L3);
	//L3.setBounds(0,120,100,30);

	//cp.add(T3);
	//T3.setBounds(100,120,100,30);



	cp.add(B1);
	B1.setBounds(0,200,100,50);

	B1.addActionListener(this);

	setDefaultLookAndFeelDecorated(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(500,500);
	setVisible(true);
	}

public void actionPerformed(ActionEvent ae)
{

try
	{

int flag =0;
if (ae.getSource()==B1)
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("jdbc:odbc:employee");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select * from empdata");
	while(rs.next())
	{
		if(rs.getInt(1)==(Integer.parseInt(T1.getText()) ) )
		{
		cp.add(L2);
		L2.setBounds(0,60,100,30);
		cp.add(T2);
		T2.setBounds(100,60,100,30);
		cp.add(L3);
		L3.setBounds(0,120,100,30);
		cp.add(T3);
		T3.setBounds(100,120,100,30);
		flag=1;		
		T2.setText(rs.getString(2));
		T3.setText(""+rs.getInt(3));
		}
		
	}
		if (flag==0)
		{
		JOptionPane.showMessageDialog(null,"record not found");
		T1.setText("");
		T2.setText("");
		T3.setText("");
				}


	}//if end

}//try end
catch(Exception e)
{}
}






};
