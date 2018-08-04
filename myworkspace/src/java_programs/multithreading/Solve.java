public final class Solve
{
	public static void main(String[] a)
	{
		Q obj=new Q();
		Prod op=new Prod(obj);
		Cons oc=new Cons(obj);
		try
		{
			op.tp.join();
			oc.tc.join();
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		return;
	}
}

class Prod implements Runnable
{
	Thread tp;
	Q q;
	Prod(Q q1)
	{
		q=q1;
		tp=new Thread(this);
		tp.start();
	}
	public void run()
	{
		int i=0;
		while(true)
		{
			q.put(++i);
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
			}
		}
	}
}

class Cons implements Runnable
{
	Thread tc;
	Q q;
	Cons(Q q2)
	{
		q=q2;
		tc=new Thread(this);
		tc.start();
	}
	public void run()
	{
		while(true)
		{
			q.get();
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
			}
		}
	}
}

class Q
{
	protected int i;
	boolean flag;
	
	synchronized void put(int n)
	{
		if(flag)
		try
		{
			wait();
		}
		catch(Exception e)
		{
		}
		i=n;
		flag=true;
		System.out.println("Produced "+n);
		notify();
	}

	synchronized void get()
	{
		if(!flag)
		try
		{
			wait();
		}
		catch(Exception e)
		{
		}
		System.out.println("Consumed "+i);
		flag=false;
		notify();
		return;
	}
}