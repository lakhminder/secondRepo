import java.io.*;
public class file_read
  
{	
	
	public static void main(String[] args) 
	{
		try
		{
		FileInputStream fis=new FileInputStream("C:/lakhminder/a.txt");
		int i=0;
		while (i!=-1)
		{
			i=fis.read();
			if (i==-1)
			{
				fis.close();
				break;

			}
			System.out.println((char)i);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
