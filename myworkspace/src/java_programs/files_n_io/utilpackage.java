import java.util.*;
class utilpackage 
{
   
    /*public String toString()
	{
	  return "object up";
	} */

	public static void main(String[] args) 
	{
		ArrayList obj=new ArrayList();
		utilpackage obj1 = new utilpackage();
		System.out.println("Hello World!");
		obj.add("hello");
		obj.add("second element");
		obj.add(obj1);
		Iterator itr=obj.iterator();
		while(itr.hasNext())
		{
			Object str;
			str=itr.next();
			System.out.println(str);
		}
			//System.out.println(obj);
	}
}
