package java_programs.multithreading;

class thd implements Runnable
{
	thd()
	{
		Thread t=new Thread(this);
		System.out.println(Thread.currentThread());
		t.start();
		System.out.println(Thread.currentThread());
	}

	public void run() 
	{
		System.out.println(Thread.currentThread());
		//Thread.sleep(1000);
		for(int i=0;i<10;i++)
		{
		  System.out.println(i);
		}
	}
	public static void main(String[] args) throws Exception
	{
		System.out.println(Thread.currentThread());
		thd obj=new thd();
		System.out.println(Thread.currentThread());
		Thread.sleep(1000);
		for(int i=0;i<10;i++)
		{
		  System.out.println("j" + i);
		}
		
	}
}
