class Q 
{
	protected int i;
	boolean flag;
	synchronized void put()
	{
	}

	
}


class producer implements Runnable
{
	Thread t1=null;
	Q q;
	producer(Q q1)
	{
		q=q1;
		t1=new Thread(this);
		t1.start();
	}
	public void run
	{ 
		int i=0;
		while (true)
		{
			q.put(++i);
			try
		}
	}
};

class consumer implements Runnable
{
	Thread t2;
	consumer(Q q1)
	{
		q=q1;
		t2=new Thread(this);
		t2.start();
	}
	public void run
	{
	}
};

class solve
{
	public static void main(String[] args) 
	{
		Q obj =new Q();
		producer op=new producer(obj);
		consumer oc=new consumer(obj);
		try
		{
			op.t1.join();
			oc.t2.join();
		}
		catch (InterruptedException e)
		{ 
		System.out.println("Hello World!" + e );			
		}

	}
};
