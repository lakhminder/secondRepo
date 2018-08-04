package test;
import java.io.*;
/*
 * for performing various file operations
 */

class file_operations
{
	/*
	 *This method writes string str into file fname
	*/
	public void file_write(String fname,String str)
	{
		PrintWriter pw=null;
		try
		{
			FileOutputStream fos= new FileOutputStream(fname);
			pw= new PrintWriter(fos);
			pw.println(str);
			//pw.close();
		}catch(Exception e)
		{
			System.out.println("Exception while writing to file(through string) /n" + e);
		}finally
		{
			//br.close();
			//pw.flush();
			pw.close();
		}
	}
	/*
	 * This method writes the contents of file fin to file fname
	 */
	public void file_write(String fname,File fin)
	{
		
		PrintWriter pw=null;
		FileReader fr=null;				
		BufferedReader br=null;
		try
		{
			String str;			
			FileOutputStream fos= new FileOutputStream(fname);
			pw= new PrintWriter(fos);			
			fr=new FileReader(fin);			
			br = new BufferedReader(fr);			
			while((str=br.readLine())!=null)
			//while((str=is.read())!=-1)
			{
				System.out.println(str);
				pw.println(str);	//writing to file after reading from flie
				//char c=(char)str;
				//pw.print(c);							
			}
			
		}catch(Exception e)
		{
			System.out.println("Exception while writing to file(through file) /n" + e);
			
		}finally
		{
			//br.close();
			//pw.flush();
			pw.close();
		}
		
	}
	/*
	 * This method asks user for input and that input is written to file fname
	 */
	public void file_write(String fname)
	{
		try
		{
			String str;
			//File file=new File(fname);
			//FileWriter fos=new FileWriter(file);
			FileOutputStream fos= new FileOutputStream(fname);
			PrintWriter pw= new PrintWriter(fos);
			System.out.println("Enter text to be writen to file:/n exit to quit" + fname);
			//pw.println(System.in);
			do
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				str=br.readLine();
				pw.println(str);								
			}while(!str.equals("exit"));
			pw.close();
		}catch(Exception e)
		{
			System.out.println("Exception while writing to file(through input) /n" + e);
		}
		
	}
		
}