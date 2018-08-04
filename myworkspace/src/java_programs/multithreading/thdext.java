package java_programs.multithreading;

class thdext extends Thread
{
	thdext()
	{
//		Thread t=new Thread(this);
		super();
		System.out.println(Thread.currentThread());
		start();
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
		thdext obj=new thdext();
		System.out.println(Thread.currentThread());
		Thread.sleep(3000);
		for(int i=0;i<10;i++)
		{
		  System.out.println("j" + i);
		}
		
	}
}
