class exc 
{
	static int a=10;
	public static void s(int x)
	{
		int b=a/x;
	}


	public static void main(String[] args) 
	{
		
		System.out.println("Hello World!");
		try{   
			s(0);
			}
		catch(Exception e)
			{
			System.out.println("hello" + e);
			}
	}
	
}
