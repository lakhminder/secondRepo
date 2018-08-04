import java.io.*;

class str
{
	public static void main(String a[])
	{
		String str1;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("enter string");
			str1=br.readLine();
			System.out.println(str1);
		   }
		catch(IOException e)
		{
		  System.out.println("errror" + e);
		}
	}
}