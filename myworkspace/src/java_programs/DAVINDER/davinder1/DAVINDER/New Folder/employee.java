import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
import java.io.*;
public class employee extends JFrame implements ActionListener
{
public String str;
public int x,y;
Container cp = getContentPane();
JLabel l1,l2,l3;
JTextField t1,t2,t3;
JButton b1,b2,b3;
Vector a1;


	employee()
	{
	super("window");

		a1 = new Vector();
l1 = new JLabel("Emp_id:");
l2 = new JLabel("Empname:");
l3 = new JLabel("Emp Age:");


t1 = new JTextField(20);
t2 = new JTextField(20);
t3 = new JTextField(20);


b1 = new JButton("Save");
b2 = new JButton("Read");
b3 = new JButton("Exit");



setLayout(null); 

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

cp.add(t3);
t3.setBounds(100,100,100,30);


cp.add(b1);
b1.setBounds(100,300,80,50);

cp.add(b2);
b2.setBounds(180,300,90,50);

cp.add(b3);
b3.setBounds(250,300,90,50);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
setDefaultLookAndFeelDecorated(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(400,400);
setVisible(true);
}
	

	public static void main(String[] args)
		{
		employee em = new employee();
		}

public void actionPerformed(ActionEvent ae) 
{		//ae begin

	try
			{
	if (ae.getSource()==b1)
	{
	a1.addElement( new emp(Integer.parseInt(t1.getText()),t2.getText(),Integer.parseInt(t3.getText())) );
	FileOutputStream fos = new FileOutputStream("employee.dat");
	ObjectOutputStream oos = new ObjectOutputStream (fos);
	oos.writeObject(a1);
	}
			}
			catch(Exception e)
			{
			System.out.println(e);
			}
			t1.setText("");
			t2.setText("");
			t3.setText("");

			 if(ae.getSource()==b2)
				{
				this.dispose();
				employee1 emp1 = new employee1();
				
				}

	}//ae end

}//class end





class emp implements Serializable
{
int id,age;
String name;
	emp(int id,String name,int age)	
	{
	this.id = id;
	this.name = name;
	this.age = age;
	}
	
}





class employee1 extends JFrame implements ActionListener
{
Container cp = getContentPane();
JLabel L1,L2,L3;
JTextField T1,T2,T3;
JButton B1;
Vector v;
static int counter=0;

employee1()
{
super("new Frame");

L1 = new JLabel("Emp_id:");
L2 = new JLabel("Empname:");
L3 = new JLabel("Emp Age:");


T1 = new JTextField(20);
T2 = new JTextField(20);
T3 = new JTextField(20);

B1 = new JButton("Next");



setLayout(null); 

cp.add(L1);
L1.setBounds(0,0,100,30);

cp.add(T1);
T1.setBounds(100,0,100,30);

cp.add(L2);
L2.setBounds(0,50,100,30);

cp.add(T2);
T2.setBounds(100,50,100,30);

cp.add(L3);
L3.setBounds(0,100,100,30);

cp.add(T3);
T3.setBounds(100,100,100,30);


cp.add(B1);
B1.setBounds(100,300,80,50);

B1.addActionListener(this);

setDefaultLookAndFeelDecorated(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(600,600);
setVisible(true);
}

public void actionPerformed(ActionEvent ae) 
{			System.out.println(counter);	
			try
			{
				if (ae.getSource()==B1)
				{
				FileInputStream fis = new FileInputStream("employee.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				v=(Vector)ois.readObject();
				emp e2=(emp)v.elementAt(counter);
						T1.setText(" "+e2.id);
						T2.setText(e2.name);
						T3.setText(" "+e2.age);
						System.out.println(e2.id+"    "+e2.name+"    "+e2.age);
					}
					
			}
			catch(Exception e)
			{
			JOptionPane.showMessageDialog(null,"record not found");
			}
			counter++;
			

}


};





