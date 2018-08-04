package test;
public class tried 
{
	public static void main(String[] args) 
	{
		equi eq =new equi();
		equi eq2 =new equi();
	if(eq.equals(eq2))
		System.out.println("equals");
	else
		System.out.println("not");
	eq.t();
	eq2.t();
	}
}
class equi 
{
		int a;
		void t()
	{
		System.out.println("Hello World!" + a);
	}
};