import java.io.*;

class deserial implements Serializable
{
  int i=10;
  double d=10.98;

  public static void main(String a[]) throws Exception
   {
	deserial obj=new deserial();
	FileInputStream fos=new FileInputStream("/ser.txt");
	ObjectInputStream oos=new ObjectInputStream(fos);
	Object o=oos.readObject();
	System.out.println(o);
   }
}
	