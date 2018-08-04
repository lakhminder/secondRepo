class c 
{
		int i;
		double d;
		c(int a,double c)
		{
			i=a;
			d=c;
		}
		public void show()
		{
			System.out.println(i + " " + d);
		}
		public void right()
		{
		i=i>>1;
		}
		public void	left()
		{
		i=i<<2;
		}
	
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");
		c obj = new c(10,23.34);
		obj.show();
		obj.right();
		obj.show();
		obj.left();
		obj.show();
	}
}
