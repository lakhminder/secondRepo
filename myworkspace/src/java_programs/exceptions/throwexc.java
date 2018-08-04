class throwexc 
{
	static int a=10;
	public static void s(int x)
	{
		try
		{
		  int b=a/x;
		  }
		  catch
		throw new Exception("yes");
	}


	public static void main(String[] args) 
	{
		
		System.out.println("Hello World!");
		try{
			s(0);
			}
		catch(Exception e)
			{
			System.out.println(" error" + e);
			}
	}
	
}
