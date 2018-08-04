import java.io.*;

class files
{
  public static void main(String a[])
  {
	File f=new File("c:/a.txt");
	System.out.println("name" + f.getName());
	System.out.println("parent" + f.getParent());
	System.out.println("parent" + f.renameTo(File "c:/b.txt"));
	System.out.println("parent" + f.getAbsolutePath());
  }
}