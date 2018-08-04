package java_programs.files_n_io;

class b 
{
	public static void main(String[] args) 
	{
		int i;
		double d;
		b(int a,double c)
		{
			i=a;
			d=c;
		}
		b obj=new b(10,23.34);
		obj.show();
		obj.right();
		obj.show()
		obj.left();
		obj.show();
	}
		show()
		{
			System.out.println(i,d);
		}
		right()
		{
		i>>1;
		}
		left()
		{
		i<<2;
		}
		
	
}
