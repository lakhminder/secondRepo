import java.io.*;

class abc
{
	public static void main(String a[])
	{
		char a;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("enter char");
			a=(char)br.read;
			System.out.println((char)a);
		   }
		catch(IOException e)
		{
		  System.out.println("errror" + e);
		}
	}
}