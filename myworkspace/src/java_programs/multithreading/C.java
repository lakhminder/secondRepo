class C extends Thread implements Runnable
{
	C()
	{
		super();
		start();
	}
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("Run "+i);
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{}
		}
	}
	public static void main(String[] a) throws Exception
	{
		C ob=new C();
		for(int j=0;j<10;j++)
		{
			System.out.println("MAIN WAS CALLED HERE");
			Thread.sleep(2000);
		}
	}
}