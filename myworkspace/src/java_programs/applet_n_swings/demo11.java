package java_programs.applet_n_swings;
import java.applet.*;
import java.awt.*;
public class demo11 extends Applet
{
	TextField t1,t2;
	Label l1,l2,l3,l4,l5;
	Choice ch;
	CheckboxGroup cbg;
	Checkbox c1,c2,c3,c4;
	Button b1,b2;
	public void init()
	{
		l1=new Label("Name");
		l2=new Label("Age");
		l3=new Label("Designation");
		l4=new Label("Gender");
		l5=new Label("Soft Drink");
		t1=new TextField(20);
		t2=new TextField(2);
		ch=new Choice();
		ch.addItem("Manager");
		ch.addItem("Peon");
		ch.addItem("Asst. Manager");
		ch.addItem("Programmer");
		cbg=new CheckboxGroup();
		c1=new Checkbox("Male",cbg,false);
		c2=new Checkbox("Female",cbg,false);
		c3=new Checkbox("Coca Cola");
		c4=new Checkbox("Pepsi");
		b1=new Button("Ok");
		b2=new Button("Cancel");
		setLayout(new GridLayout(7,2));
		add(l1);add(t1);
		add(l2);add(t2);
		add(l3);add(ch);
		add(l4);add(l5);
		add(c1);add(c3);
		add(c2);add(c4);
		add(b1);add(b2);
	}
}
//<applet code=demo11.class width=300 height=300></applet>

