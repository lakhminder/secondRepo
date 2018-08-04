import java.io.*;

public class assignment1
{

public static void main(String[] arg)
{
	String strID="",strName="",strAge="";
	String str = "";
	System.out.println("\n\n\n\n\t\t\tMAIN MENU");
	System.out.println("\t 1.Add record");
	System.out.println("\t 2.Search ");
	System.out.println("\t 3.Edit");
	System.out.println("\t 4.Delete");
	System.out.println("\t 5.Exit");
	System.out.println("\n\n\t Enter you choice");
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	try
	{
	
	str = (String)br.readLine();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	int choice = Integer.parseInt(str);
	
	switch(choice)
	{
		case 1:
			try
			{
			FileOutputStream fos = new FileOutputStream("st1.txt",true);
			PrintWriter pw = new PrintWriter(fos,true);
			while(true)
			{
				System.out.println("Enter ID");
				int strID1 = Integer.parseInt(br.readLine());
				System.out.println("Enter Name");
				strName = (String)br.readLine();
				System.out.println("Enter Age");
				strAge = (String)br.readLine();
				pw.println(""+strID);
				pw.println(strName);
				pw.println(strAge);
				System.out.println("Data successfully written.");
				System.out.println("\n\n\tDo you want to continue(y/n)");
				str = (String)br.readLine();
				if(str.equals("n"))
					break;

			}
			fos.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		break;
		case 2:
			
			try
			{
				System.out.println("Enter the ID to be searched");
				strID = (String)br.readLine();
	
				FileInputStream fis = new FileInputStream("st1.txt");
				BufferedReader br1 = new BufferedReader(new InputStreamReader(fis));
				while(true)
				{
					str = (String)br1.readLine();
					if(str.equals(null))
						break;
					//System.out.println(str);

					if(str.equals(strID))
					{
						System.out.println("ID     "+strID);
						strName =(String)br1.readLine();
						System.out.println("Name   "+strName);
						strAge = (String)br1.readLine();								System.out.println("Age    "+strAge);
					}
				}
				fis.close();
			}
			catch(Exception e)	
			{
				System.out.println(e);
			}
		break;
		case 3:
			try
			{
				System.out.println("Enter the ID to be edited");
				strID = (String)br.readLine();
	
				FileInputStream fis = new FileInputStream("st1.txt");
				BufferedReader br1 = new BufferedReader(new InputStreamReader(fis));
				FileOutputStream fos = new FileOutputStream("st2.txt");
			PrintWriter pw = new PrintWriter(fos,true);
				while(true)
				{
					str = (String)br1.readLine();
					if(str.equals(null))
						break;
					//System.out.println(str);

					if(str.equals(strID))
					{
						pw.println(strID);
						System.out.println("Enter Name ");
						strName = (String)br.readLine();
						pw.println(strName);
						System.out.println("Enter Age ");
						strAge = (String)br.readLine();									pw.println(strAge);
						br1.readLine();
						br1.readLine();
					}
					else
					{
						pw.println(str);
						strName =(String)br1.readLine();
						pw.println(strName);
						strAge = (String)br1.readLine();
						pw.println(strAge);
					}
				}
				fis.close();
				fos.close();
				
				
			}
			catch(Exception e)	
			{
				//System.out.println(e);
			}

			//Rename mechanism
			try
			{
			
				FileInputStream fis = new FileInputStream("st2.txt");
				BufferedReader br1 = new BufferedReader(new InputStreamReader(fis));
			FileOutputStream fos = new FileOutputStream("st1.txt");
			PrintWriter pw = new PrintWriter(fos,true);
				while(true)
				{
					str = (String)br1.readLine();
					if(str.equals(null))
						break;
					
					pw.println(str);
					strName =(String)br1.readLine();
					pw.println(strName);
					strAge = (String)br1.readLine();
					pw.println(strAge);
					
				}
				fis.close();
				fos.close();
				
				
			}
			catch(Exception e)	
			{
				//System.out.println(e);
			}
			System.out.println("Data has been succesfully edited");
		break;
		case 4:
			try
			{
				System.out.println("Enter the ID to be deleted");
				strID = (String)br.readLine();
	
				FileInputStream fis = new FileInputStream("st1.txt");
				BufferedReader br1 = new BufferedReader(new InputStreamReader(fis));
				FileOutputStream fos = new FileOutputStream("st3.txt");
			PrintWriter pw = new PrintWriter(fos,true);
				while(true)
				{
					str = (String)br1.readLine();
					if(str.equals(null))
						break;
					//System.out.println(str);

					if(str.equals(strID))
					{
						
						br1.readLine();
						br1.readLine();
					}
					else
					{
						pw.println(str);
						strName =(String)br1.readLine();
						pw.println(strName);
						strAge = (String)br1.readLine();
						pw.println(strAge);
					}
				}
				fis.close();
				fos.close();
				
				System.out.println("Data has been succesfully deleted");
			}
			catch(Exception e)	
			{
				//System.out.println(e);
			}

			//Rename mechanism
			try
			{
			
				FileInputStream fis = new FileInputStream("st3.txt");
				BufferedReader br1 = new BufferedReader(new InputStreamReader(fis));
			FileOutputStream fos = new FileOutputStream("st1.txt");
			PrintWriter pw = new PrintWriter(fos,true);
				while(true)
				{
					str = (String)br1.readLine();
					if(str.equals(null))
						break;
					
					pw.println(str);
					strName =(String)br1.readLine();
					pw.println(strName);
					strAge = (String)br1.readLine();
					pw.println(strAge);
					
				}
				fis.close();
				fos.close();
				
				
			}
			catch(Exception e)	
			{
				//System.out.println(e);
			}
			System.out.println("Data has been succesfully deleted");
		break;
		case 5:
			System.exit(0);
		break;
	}
}
}