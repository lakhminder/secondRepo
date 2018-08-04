import java.io.*;
public class file_write
  
{	
	
	public static void main(String[] args) 
	{
		try
		{
		FileOutputStream fos=new FileOutputStream("C:/lakhminder/a.txt",true);
		System.out.println("enter string");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		byte b[]=str.getBytes();
		fos.write(b);
		fos.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
