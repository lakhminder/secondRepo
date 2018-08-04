import java.io.*;

class serial implements Serializable
{
  int i=10;
  double d=10.98;

  public static void main(String a[]) throws Exception
   {
	serial obj=new serial();
	FileOutputStream fos=new FileOutputStream("/ser.txt");
	ObjectOutputStream oos=new ObjectOutputStream(fos);
	oos.writeObject(obj);
   }
}
	