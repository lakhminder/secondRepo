import java.io.*;
import java.lang.*;



public class empdata1
{
 
String name,add,empid;
static File dir;
static String ab;

	public void addrecords()
	{	
		try
		{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the Employee Name");
	name=br.readLine();
	System.out.println("\n");

	System.out.println("Enter the Employee id");
	empid = br.readLine();
	System.out.println("\n");

	System.out.println("Enter the Employee Address");
	add=br.readLine();
	System.out.println("\n");

	RandomAccessFile raf = new RandomAccessFile(ab+"/"+name+".txt","rw");
	raf.seek(raf.length());
	raf.writeBytes(name+ "\t"+empid+"\t"+add+"\t");
	raf.close();
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
	}//end addrecord method



	public void displayrecords() throws IOException
	{
		File f1=new File(ab+"/");
		String s1[]=f1.list();
		for(int i=0;i<s1.length;i++)
		{
			for(int y=0;y<s1[i].length();y++)
			{
				if(s1[i].charAt(y)=='.')
				{
					int q=y;
					String x2=s1[i].substring(0,q);
					System.out.println("File Name::\t"+x2);
					RandomAccessFile raf = new RandomAccessFile(ab+"/"+x2+".txt","rw");
					while(raf.getFilePointer()<raf.length())
					{
						  
						System.out.print("Records::\t"+raf.readLine());
						System.out.println("\n");

					}
				}
			}
		}
	}//display records
	


	public void search() throws IOException
	{
		System.out.print("Enter the name whose records to be searched\t");
		BufferedReader br3=new BufferedReader(new InputStreamReader(System.in));
		String str=br3.readLine();
		File f1=new File(ab+"/");
		String s1[]=f1.list();
		String s2[]=f1.list();
		int count=0;
		for(int i=0;i<s1.length;i++)
		{
			for(int y=0;y<s1[i].length();y++)
			{
				if(s1[i].charAt(y)=='.')
				{
					int q=y;
					s2[i]=s1[i].substring(0,q);
					count++;
				 }
			}
		}
		for(int i=0;i<count;i++)
		{
			if(s2[i].equals(str))
			{	
				System.out.println("File Name::\t"+s2[i]);
				RandomAccessFile raf = new RandomAccessFile(ab+"/"+s2[i]+".txt","rw");
				while(raf.getFilePointer()<raf.length())
				{							  
					System.out.print("Records::\t"+raf.readLine());
					System.out.println("\n");
				}
			}
		}
 }
		
				


				public void delete()
				{

				}



public static void main(String[] args)
{   //psvm begin

		try
		{
			int c;
			String m;
			empdata1 emp = new empdata1();
			dir=new File("c:/emp");
			dir.mkdir();
			ab=dir.getPath();
			System.out.println(ab);

		do	{
		
		System.out.println("\tMAIN Menu");
		System.out.println("1.Add Records\n2.Display Records\n3.Search\n4.Delete\n5.Exit");
		BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
		m=b.readLine();
		int x=Integer.parseInt(m);
		c=x;
		switch (x)
		{
		case 1: emp.addrecords();
				break;
		case 2: emp.displayrecords();
				break;
		case 3: emp.search();
				break;	
		case 4:	emp.delete();
				break;
		case 5: break;
		}
			}
		while(c!=5);
		}
		catch(Exception e){System.out.println(e);}

}//psvm end



};// class end