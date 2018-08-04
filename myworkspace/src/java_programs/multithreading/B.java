class B implements Runnable
{
	Thread t;
	B()
	{
		t=new Thread(this);
		t.start();
	}
	public void run()
	{
		//System.out.println("THREAD");
		for(int j=0;j<10;j++)
		{
			System.out.println("THREAD "+j);
		}
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{}
	}

	public static void main(String[] a)
	{
		B ob=new B();
		//System.out.println("MAIN");
		for(int i=0;i<10;i++)
		{
			System.out.println("MAIN "+i);
		}
	}
}