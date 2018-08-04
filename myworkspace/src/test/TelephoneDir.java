package test;
import java.io.*;
import java.util.*;
class TelephoneDir
{	
	public static void main(String arg[])
	{
		new DirFile();
	}
}

class DirFile
{
	int i;
	//int number; 
	String name,number;
	PrintWriter pw;
	BufferedReader br;
	DirFile()
	{
		try
		{
			do{	
				System.out.println("MENU:\n");
				System.out.println("1:Add \n2:Modify \n3:Delete \n4:Search \n5:Exit \n");
				br=new BufferedReader(new InputStreamReader(System.in));
				i=Integer.parseInt(br.readLine());
				switch(i)
				{
				case 1:
					this.add();
					break;
					/*System.out.println("Enter name:");
					name=br.readLine();
					pw=new PrintWriter(new FileOutputStream("c:/telephone.dat",true));
					pw.println(name);

					try
					{
						while(true)
						{
							System.out.println("Enetr number:");
							number=Integer.parseInt(br.readLine());
							break;
						}
					 }catch(NumberFormatException e)
					 {
						System.out.println("enter number only");							
					 }										
					pw.close();
					break;*/
				case 2:
					this.modify();
					break;
				case 3:
					this.delete();
					break;
				case 4:
					this.search();
					break;
				default:					
					System.exit(0);

				}			
			}while(i!=5);
		}catch(Exception e)
		{
			System.out.println("Exception is: " + e);
		}
	}

	void add()
	{
		try
		{
			br=new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter name:");
			name=br.readLine();
			pw=new PrintWriter(new FileOutputStream("c:/telephone.dat",true));
			//pw.println(name);


			System.out.println("Enter number:");
			number=br.readLine();


		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			pw.println(name);
			pw.println(number);
			pw.close();
		}

	}

	void modify()
	{
		String str;
		try
		{
			br=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader fbr=new BufferedReader(new FileReader("c:/telephone.dat"));
			String temp;
			System.out.println("Enter name to be modified:");
			name=br.readLine();
			pw=new PrintWriter(new FileOutputStream("c:/telephone.temp"));
			//pw.println(name);
			while((temp=fbr.readLine())!=null)
			{
				if(temp.equals(name))
				{
					pw.println(temp);
					temp=fbr.readLine();
					System.out.println("you are going to modify: " + temp );	
					System.out.println("Enter new umber:");
					number=br.readLine();
					pw.println(number);
					continue;

				}
				pw.println(temp);


			}
			pw.close();
			pw=new PrintWriter(new FileOutputStream("c:/telephone.dat"));
			FileReader fr=new FileReader("c:/telephone.temp");
			br=new BufferedReader(fr);
			while((str=br.readLine())!=null)				
			{
				//System.out.println(str);
				pw.println(str);	//writing to file after reading from flie
				//char c=(char)str;
				//pw.print(c);							
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			//pw.println(name);
			//pw.println(number);
			pw.close();
		}

	}

	void delete()
	{

		String str;
		try
		{
			br=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader fbr=new BufferedReader(new FileReader("c:/telephone.dat"));
			String temp;
			System.out.println("Enter name to be deleted:");
			name=br.readLine();
			pw=new PrintWriter(new FileOutputStream("c:/telephone.temp"));
			//pw.println(name);
			while((temp=fbr.readLine())!=null)
			{
				if(temp.equals(name))
				{
					//pw.println(temp);
					temp=fbr.readLine();
					//System.out.println("you are going to modify: " + temp );	
					//System.out.println("Enter new umber:");
					//number=br.readLine();
					//pw.println(number);
					continue;

				}
				pw.println(temp);


			}
			pw.close();
			pw=new PrintWriter(new FileOutputStream("c:/telephone.dat"));
			FileReader fr=new FileReader("c:/telephone.temp");
			br=new BufferedReader(fr);
			while((str=br.readLine())!=null)				
			{
				//System.out.println(str);
				pw.println(str);	//writing to file after reading from flie
				//char c=(char)str;
				//pw.print(c);							
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			//pw.println(name);
			//pw.println(number);
			pw.close();
		}


	}

	void search()
	{

		String str;
		try
		{
			br=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader fbr=new BufferedReader(new FileReader("c:/telephone.dat"));
			String temp;
			System.out.println("Enter name to be searched:");
			name=br.readLine();
			//pw=new PrintWriter(new FileOutputStream("c:/telephone.temp"));
			//pw.println(name);
			while((temp=fbr.readLine())!=null)
			{
				if(temp.equalsIgnoreCase(name))
				{
					//pw.println(temp);
					temp=fbr.readLine();
					System.out.println("The number for " + name +"is :" + temp );	
					//System.out.println("Enter new umber:");
					//number=br.readLine();
					//pw.println(number);
					//continue;
					break;

				}
				//pw.println(temp);


			}
			/*pw.close();
			pw=new PrintWriter(new FileOutputStream("c:/telephone.dat"));
			FileReader fr=new FileReader("c:/telephone.temp");
			br=new BufferedReader(fr);
			while((str=br.readLine())!=null)				
			{
				//System.out.println(str);
				pw.println(str);	//writing to file after reading from flie
				//char c=(char)str;
				//pw.print(c);							
			}*/

		}catch(Exception e)
		{
			e.printStackTrace();
		}/*finally
		{
			//pw.println(name);
			//pw.println(number);
			pw.close();
		}*/


	}
}