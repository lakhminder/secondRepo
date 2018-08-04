import java.net.*;
class con1
{
	public static void main(String[] args) 
	{	
		URL url=null;
		try
		{
			url=new URL("http://yahoo.com");
		}
		catch (Exception e)
		{
			System.out.println("Hello " + e);	
		}
		System.out.println(url.getPort());
		System.out.println(url.getHost());
		System.out.println(url.getProtocol());
		
	}
}
