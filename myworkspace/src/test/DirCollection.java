package test;

import java.io.*;
import java.util.*;

class DirCollection
{
	ArrayList lt=new ArrayList();
	BufferedReader br;
	int i;
	//int number; 
	String name,number;
	//PrintWriter pw;
	DirCollection()
	{
		
		try
		{
			FileInputStream fos=new FileInputStream("Telephone.dat");					
			ObjectInputStream oos=new ObjectInputStream(fos);
			lt=(ArrayList)oos.readObject();
			oos.close();
		}catch(FileNotFoundException e)
		{
			System.out.println("File doesn,t exist,so it will be created");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
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
					this.exit();
				//System.exit(0);
				
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
			System.out.println("Enter number:");
			number=br.readLine();
			lt.add(name);
			lt.add(number);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void exit()
	{
		try
		{				
			FileOutputStream fos = new FileOutputStream("Telephone.dat");
			ObjectOutputStream oos = new ObjectOutputStream (fos);
			oos.writeObject(lt);
			oos.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	void modify()
	{
		int i=-1;
		int flag=0;
		String st1,num,ans;
		
		try
		{
			br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter name to be modified:");
			name=br.readLine();
			//System.out.println("Enter new number:");
			//number=br.readLine();
			
			Iterator itr=lt.iterator();
			while(itr.hasNext())
			{		
				i=i+1;
				//if((st1=(String)itr.next()).equalsIgnoreCase(name))
				/*
				 * this if checks whether name itself or as a substring of any names in directory
				 * is present
				 */
				if(((st1=(String)itr.next()).toLowerCase()).indexOf((name.toLowerCase()))!=-1)
				{
					//i=i+1;
					num=(String)itr.next();
					System.out.println("Do you want to modify " + st1 +"("+ num + ") [y/n]");
					ans=br.readLine();
					if(ans.equalsIgnoreCase("y"))
					{	
						
						System.out.println("Enter new number:");
						number=br.readLine();
						
						lt.set(i+1,number);
						System.out.println("Number " + num + " has been changed to " + number );
						flag=1;
						break;
					}
					else
					{
						i=i+1;//if there are more than one instances of same name
					}
				}
				
			}
			if(flag==0)
			{
				System.out.println("This " + name + " does not exist in directory");	
			}
			
			//lt.add(name);
			//lt.add(number);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void delete()
	{
		
		int i=-1;
		int flag=0;
		String st1,num,ans;
		
		try
		{
			br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter name to be deleted");
			name=br.readLine();
			//System.out.println("Enter new number:");
			//number=br.readLine();
			
			Iterator itr=lt.iterator();
			while(itr.hasNext())
			{		
				i=i+1;
				//if((st1=(String)itr.next()).equalsIgnoreCase(name))
				/*
				 * this if checks whether name itself or as a substring of any names in directory
				 * is present
				 */
				if(((st1=(String)itr.next()).toLowerCase()).indexOf((name.toLowerCase()))!=-1)
				{
					//i=i+1;
					num=(String)itr.next();
					System.out.println("Do you want to delete " + st1 +"("+ num + ") [y/n]");
					ans=br.readLine();
					if(ans.equalsIgnoreCase("y"))
					{	
						
						//System.out.println("Enter new number:");
						//number=br.readLine();
						
						//lt.set(i+1,number);
						lt.remove(i);
						lt.remove(i);
						System.out.println("Contact " + st1 +"("+ num + ") has been deleted ");
						flag=1;
						break;
					}
					else
					{
						i=i+1;//if there are more than one instances of same name
					}
				}
				
			}
			if(flag==0)
			{
				System.out.println("This " + name + " does not exist in directory");	
			}
			
			//lt.add(name);
			//lt.add(number);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	void search()
	{
		int i=-1;
		int flag=0;
		String st1,num,ans;
		
		try
		{
			br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter name to be searched");
			name=br.readLine();
			//System.out.println("Enter new number:");
			//number=br.readLine();
			
			Iterator itr=lt.iterator();
			while(itr.hasNext())
			{		
				
				//if((st1=(String)itr.next()).equalsIgnoreCase(name))
				/*
				 * this if checks whether name itself or as a substring of any names in directory
				 * is present
				 */
				if(((st1=(String)itr.next()).toLowerCase()).indexOf((name.toLowerCase()))!=-1)
				{
					//i=i+1;
					flag=1;
					num=(String)itr.next();
					System.out.println("The number for contact " + st1 +" is; "+ num );
					//ans=br.readLine();
					
				}
				
			}
			if(flag==0)
			{
				System.out.println("This " + name + " does not exist in directory");	
			}
			
			//lt.add(name);
			//lt.add(number);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
}







