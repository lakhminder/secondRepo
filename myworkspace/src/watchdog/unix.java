package watchdog;
import java.io.*;
class unix 
{
	static Runtime runtime; 
	static String cmd="dir";
	public static void main(String[] args) 
	{
		String s=null;
		runtime= Runtime.getRuntime();
		System.out.println("Hello World!1");
		try
		{
		
			Process p1 = runtime.exec(cmd);
			BufferedReader inp = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			 // read the output from the command
			System.out.println("Here is the standard output of the command:");
			while((s = inp.readLine()) != null) 
			{
				System.out.println(s);
			}
		}
		catch (Exception e)
		{
			System.out.println(e + " 23");
		}
		System.out.println("Hello World!2");
	}
}
