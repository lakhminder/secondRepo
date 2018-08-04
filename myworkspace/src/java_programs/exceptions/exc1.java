public class exc1
{
	static int i=10;
	static void s() throws b1
	{
		if(i==10)
		{
			throw new b1("yes"); //user defined exception
		}
	}
	public static void main(String a[])
	{
		try
		{
			s();
		}
		catch(b1 e)
		{
			System.out.println("err" + e );
		}
	}

}

class b1 extends Exception //if created as inner class , must be declared static as call will be 
							//	made from static method [s()]
	{
		String msg;
		b1(String msg1)
		{
			msg=msg1;
		}
		
		public String toString()
		{
			return msg;
		}
	}