import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

 public class Serialgui extends JFrame implements ActionListener
{
   JTextField tf=null;
   JButton b1,b2;
   Container c; 
   Serialgui(String title)
   {
     super(title);
	 c=getContentPane();
	 c.setLayout(new GridLayout(2,2));
     tf=new JTextField(30);
	 b1=new JButton("Serial");
	 b2=new JButton("Deserial");
	 c.add(tf);c.add(new JLabel(""));
	 c.add(b1);c.add(b2);
	 setSize(300,300);
	 setVisible(true);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 b1.addActionListener(this);
	 b2.addActionListener(this);
   }
   public void actionPerformed(ActionEvent ae )
   {
     if(ae.getSource()==b1)
	 {
		try
		{
		String str=tf.getText();
		Object ob=(Object)str;
	    FileOutputStream fos=new FileOutputStream("c:/a.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(ob);
		JOptionPane.showMessageDialog(null,"Sucessfully serialised","Success",JOptionPane.PLAIN_MESSAGE);
		}
		catch(Exception e)
		{
		}
	 }
	 if(ae.getSource()==b2)
	 {
	   try
		{
		   FileInputStream fis=new FileInputStream("c:/a.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
        Object o=ois.readObject();

		JOptionPane.showMessageDialog(null,"Sucessfully Deserialised "+o.toString(),"Success",JOptionPane.PLAIN_MESSAGE);
		}
		catch(Exception e)
		{
		}

	 }
   }
   public static void main(String args[])
   {
     Serialgui sg=new Serialgui("SERIAL---DESERIAL");
   }
}
