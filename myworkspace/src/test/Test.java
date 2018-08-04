package test;
import java.io.*;
import java.util.*;
import excel.Worksheet;
import java.net.URLDecoder;
import java.net.URLEncoder;
import net.sf.json.JSONSerializer;

import org.apache.commons.lang.StringUtils;

public class Test
{
	///static ArrayList a=new ArrayList();
	public static String getINCondStrFromStringListWithSameCase(ArrayList stringList)
	{
		if(!stringList.isEmpty())
		{
			StringBuffer str = new StringBuffer("(");
			for(Iterator itr =stringList.iterator();itr.hasNext(); )
			{
				String element = (String) itr.next();
				if (StringUtils.isNotBlank(element))
				{
					str.append("'").append(element).append("', ");
				}
			}
			String finalCondition = StringUtils.chop(str.toString().trim());
			finalCondition += ")";
			return finalCondition;
		}else 
			return null;
	}
	
	public String testJunit1()
	{
		return "1";
	}
	
	public String testJunit2()
	{
		return "2";
	}
	
	public String testJunit3()
	{
		return "3";
	}
	//static String st1="jksgh";
	public static void main(String[] args)
	{
		//main(5);
		//new Comparison1().fill();
		//new ConvertToRange().display();
		//new Worksheet().make();
		//Long.parseLong("0123456789012345678901234");
		TestVO a = new TestVO("123", "123","123", "123","123");
		TestVO b = new TestVO("123", "123","123", "123","123");
		if(a.equals(b))
			System.out.println("Success!!");
		else
			System.out.println("Fail!!");
		
		StringBuffer str = new StringBuffer();
		String str2 = null;
		String str1 = "asd" + str.toString();
		//System.out.println(str1.length() + str.toString());
		//System.out.println("Date is2:" + "D".equals(str1));
		String idParam = null;
		String versionNoParam = null;
		if(idParam != null && !idParam.equals("") &&
				versionNoParam != null && !versionNoParam.equals(""))
		{
			//System.out.println("Date is:" + new Date());
			//System.out.println(Integer.valueOf(str1));
			//isMNSIBMOrder = getRemoteObject().isMNSIBMOrder(Long.valueOf(idParam),Integer.valueOf(versionNoParam), getUserSessionInfo(request));
		}
		
		
		/*Map networkableNodeNTSRMap = new Hashtable();
		Map portMap = null;
		portMap = (Map)networkableNodeNTSRMap.get("PORT");
		if(portMap == null)
		{
			portMap = new Hashtable();
			networkableNodeNTSRMap.put("PORT", portMap);
		}
		portMap.put("one", "three");*/
		/*Hashtable numbers = new Hashtable();
	     numbers.put(new Long(1), new Integer(1));
	     numbers.put(new Long(4), new Integer(2));
	     numbers.put("three", new Integer(3));
	     numbers.put("three", new Integer(6));
		int cnt = 50/75;
		numbers.remove(new Long(4));
		System.out.println(numbers.get("three"));
		System.out.println((String)numbers.get("t"));*/
		
		int i = 109/25;
		//Long serviceAddressId=str == null ? null : new Long(Long.parseLong(str));
		//System.out.println(serviceAddressId);
		//System.out.println(JSONSerializer.toJSON(a));
		//for(Iterator itr=a.iterator();itr.hasNext();)
		//{
			// System.out.println(itr.next());	
		//}
		
		/*try
		{
			String userdir= System.getProperty("user.dir");
			System.out.println(010);
    		System.out.println("Userdir is \n"+userdir);
			String str = "Q.ADVAN+M";
			String enc = URLEncoder.encode(str,"UTF-8");
			System.out.println(enc);
			String dec = URLDecoder.decode(enc,"UTF-8");
			System.out.println(dec);
		}catch(Exception e)
		{
			e.printStackTrace();
		}*/
		//int port = Integer.parseInt(st1);
		//new DirCollection();
		/*try
		{
			FileInputStream fos=new FileInputStream("Telephone.dat");

			ObjectInputStream oos=new ObjectInputStream(fos);
			a=(ArrayList)oos.readObject();
			Iterator itr=a.iterator();
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}
			//new file_operations().file_write("c:/test/first_file.txt",new File("c:/test/unix.java"));
			System.out.println("Hello World!" );
		}catch(Exception e)
		{
			e.printStackTrace();
		}*/
	}
	/*public static void main(int x)
	{
		System.out.println("x= " + x );
	}*/
}
