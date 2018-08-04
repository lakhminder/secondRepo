import java.io.*;

class number
{
	public static void main(String a[])
	{
		int n;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//Integer ir=new
		try{
			System.out.println("enter number");
			//str1=br.readLine();
                        n = Integer.parseInt(br.readLine());
			System.out.println(n);
		   }
		catch(Exception e)
		{
		  System.out.println("errror" + e);
		}
	}
}