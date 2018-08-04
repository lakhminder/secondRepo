package test;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

class Prop
{
	Properties pr=new Properties();
	FileInputStream fir;
	public void doit()
	{

		try{			
			fir=new FileInputStream("src/test/config/prop");
			pr.load(fir);
			System.out.println(pr.getProperty("1"));
			//pr.setProperty("1","first");
			//pr.setProperty("2","second");
			pr.store(new FileOutputStream("src/test/config/prop"),"heading");
		}catch(FileNotFoundException fe)
		{
			fe.printStackTrace();
			try
			{
				pr.store(new FileOutputStream("src/test/config/prop"),"heading");				
				this.doit();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}



	}
}
class test1 
{
	/*public static void main(String[] args) 
	{
		//Prop p1=new Prop();
		//p1.doit();
		/*System.out.println(new Date(System.currentTimeMillis()));
		try
		{
			Thread.sleep(1000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(new Date());
		System.out.println(new Date(System.currentTimeMillis()));///*
		String st="10";
		int i=Integer.parseInt(st);
		String st1=st.valueOf(i);
		Integer i1=Integer.valueOf(st);
		Float f1=Float.valueOf(st);
		System.out.println("Integer i1:" + i1);
		System.out.println("Float f1:" + f1);

	}*/
	Map map = new LinkedHashMap();
	public test1()
	{
		int i=0;
		String fileName = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		fileName = sdf.format(new java.util.Date());
		System.out.println("fileName:  " + fileName);
		while(i<2)
		{
			String nni = "490001" + i;
			System.out.println("nni:"+nni);
			String userId = "user" + i;
			String pwd = "passwd" + i;
			String ipAddr = "ipaddr" + i;
			int port = Integer.parseInt("1234" + i);
			map.put(nni, (userId+"~"+pwd+"~"+ipAddr+"~"+port));
			i++;
		}
		System.out.println("map.values():  "+ map.values());
		Set set = map.keySet();
		
		Iterator iter = set.iterator();
		System.out.println("map.size():  " + map.size());

		while (iter.hasNext())
		{

			//Map.Entry entry = (Map.Entry) iter.next();
			String nni = (String) iter.next();
			System.out.println("key:  " + nni);
			String AXE = (String) map.get(nni);
			System.out.println("value:  " + AXE);
		}


	}

}

class Sort1
{
	ArrayList tnSummary = new ArrayList();
	public void sorting()
	{
		tnSummary.add(new TestVO("loc1", "add1", "9999999945", "P" ,"DID"));
		tnSummary.add(new TestVO("loc1", "add1", "9999999946", "P" ,"DID"));
		tnSummary.add(new TestVO("loc1", "add1", "9999999950", "P" ,"DID"));
		tnSummary.add(new TestVO("loc1", "add1", "9999999949", "P" ,"DID"));
		tnSummary.add(new TestVO("loc1", "add1", "9999999953", "R" ,"STANDARD"));
		tnSummary.add(new TestVO("loc1", "add1", "9999999947", "P" ,"DID"));
		tnSummary.add(new TestVO("loc1", "add1", "9999999951", "P" ,"DID"));
		tnSummary.add(new TestVO("loc1", "add1", "9999999952", "P" ,"DID"));
		
		
		System.out.println("unsorted :" + tnSummary);
		Collections.sort(tnSummary);
		System.out.println("sorted :" + tnSummary);
	}
}

class ConvertToRange
{
	public void display()
	{
		ArrayList tnList = new ArrayList();
		ArrayList sortedTnList = new ArrayList();
		LinkedList tempList = new LinkedList();
		tnList.add(new VNVO("9999999946", new Long("9999999946")));
		tnList.add(new VNVO("9999999947", new Long("9999999947")));
		tnList.add(new VNVO("9999999948", new Long("9999999948")));
		tnList.add(new VNVO("9999999951", new Long("9999999951")));
		tnList.add(new VNVO("9999999952", new Long("9999999952")));
		tnList.add(new VNVO("9999999957", new Long("9999999957")));
		tnList.add(new VNVO("9999999958", new Long("9999999958")));
		tnList.add(new VNVO("9999999959", new Long("9999999959")));
		System.out.println("unsorted :" + tnList);
		Long prevTelephoneNumber = new Long(0L);
		String prevTelephoneValue = "";
		
		if(tnList.size()>0)
		{
			prevTelephoneNumber = ((VNVO)tnList.get(0)).getTNNumberL();
			
		}
		VNVO samplVnVO = new VNVO();
		samplVnVO.setTNNumberL(new Long(1L));
		tnList.add(samplVnVO);//added to get last record
		for (Iterator itr=tnList.iterator();itr.hasNext();)
		{
			VNVO vnVO = (VNVO)itr.next();
			Long telephoneNumber = vnVO.getTNNumberL();
			long prevTN = prevTelephoneNumber.longValue() + 1;
			if(telephoneNumber.equals(prevTelephoneNumber))//very first number
			{
				//do nothing
			}else if(new Long(prevTN).equals(telephoneNumber))//they are in sequence
			{
				if(tempList.size()==0)
				{
					tempList.addLast(prevTelephoneNumber.toString());
					tempList.addLast(telephoneNumber.toString());
				}else
				{
					tempList.addLast(telephoneNumber.toString());
				}
				
			}else if(tempList.size()>0)
			{
				//StringBuffer telSeq = new StringBuffer(tempList.getFirst().toString());
				StringBuffer telSeq = new StringBuffer(tempList.getFirst().toString().substring(0, 3));
				//String finalSeq = ((Long)tempList.getLast()).toString().substring(6, 10);
				telSeq.append("-");
				telSeq.append(tempList.getFirst().toString().substring(3, 6));
				telSeq.append("-");
				telSeq.append(tempList.getFirst().toString().substring(6, 10));
				telSeq.append("-");
				telSeq.append(tempList.getLast().toString().substring(6, 10));
				sortedTnList.add(new VNVO(telSeq.toString(), new Long(telSeq.toString().replaceAll("-", ""))));
				tempList.clear();
				
			}else
			{
				StringBuffer telSeq = new StringBuffer(prevTelephoneNumber.toString().substring(0, 3));
				telSeq.append("-");
				telSeq.append(prevTelephoneNumber.toString().substring(3, 6));
				telSeq.append("-");
				telSeq.append(prevTelephoneNumber.toString().substring(6, 10));
				sortedTnList.add(new VNVO(telSeq.toString(), prevTelephoneNumber));
			}
			prevTelephoneNumber = telephoneNumber;
		}
		
		System.out.println("sorted :" + sortedTnList);
	}
}

class Comparison1
{
	
	ArrayList tnSummary = new ArrayList();
	ArrayList tnSummarySorted = new ArrayList();
	LinkedList tempList = new LinkedList();
	  //new TestVO("loc1", "add1", new Integer(45), "P" ,"DID");
	public void fill()
	{
		tnSummary.add(new TestVO("loc1", "add1", new Long(9999999945L), "P" ,"DID"));
		tnSummary.add(new TestVO("loc1", "add1", new Long(9999999946L), "P" ,"DID"));
		tnSummary.add(new TestVO("loc1", "add1", new Long(9999999947L), "P" ,"DID"));
		tnSummary.add(new TestVO("loc1", "add1", new Long(9999999949L), "P" ,"DID"));
		tnSummary.add(new TestVO("loc1", "add1", new Long(9999999950L), "P" ,"DID"));
		tnSummary.add(new TestVO("loc1", "add1", new Long("9999999951"), "P" ,"DID"));
		tnSummary.add(new TestVO("loc1", "add1", new Long(9999999952L), "P" ,"DID"));
		tnSummary.add(new TestVO("loc1", "add1", new Long(9999999953L), "R" ,"STANDARD"));
		System.out.println(tnSummary);
		formSeries();
	}
	public void formSeries()
	{
		
		String prevLocationName = "";
		String prevAddress = "";
		Long prevTelephoneNumber = new Long(0L);
		String prevTelephoneValue = "";
		String prevTnType = "";
		String prevTnCategory = "";
		if(tnSummary.size()>0)
		{
			prevLocationName = ((TestVO)tnSummary.get(0)).getLocationName();
			prevAddress = ((TestVO)tnSummary.get(0)).getAddress();
			prevTelephoneNumber = ((TestVO)tnSummary.get(0)).getTelephoneNumber();
			prevTnType = ((TestVO)tnSummary.get(0)).getTnType();
			prevTnCategory = ((TestVO)tnSummary.get(0)).getTnCategory();
			
		}
		tnSummary.add(new TestVO("test", "test", new Long(1L), "test", "test"));//added to get last record
		
		for (Iterator itr=tnSummary.iterator();itr.hasNext();)
		{
			TestVO testVO = (TestVO)itr.next();
			String locationName = testVO.getLocationName();
			String address = testVO.getAddress();
			Long telephoneNumber = testVO.getTelephoneNumber();
			//String telephoneValue = ((TestVO)itr.next());
			String tnType = testVO.getTnType();
			String tnCategory = testVO.getTnCategory();
			if(locationName.equals(prevLocationName) &&
				address.equals(prevAddress) &&
				//!telephoneNumber.equals(prevTelephoneNumber) &&
				tnType.equals(prevTnType) &&
				tnCategory.equals(prevTnCategory)
				)
			{
				long prevTN = prevTelephoneNumber.longValue() + 1;
				if(telephoneNumber.equals(prevTelephoneNumber))//very first number
				{
					//do nothing
				}else if(new Long(prevTN).equals(telephoneNumber))//they are in sequence
				{
					if(tempList.size()==0)
					{
						tempList.addLast(prevTelephoneNumber.toString());
						tempList.addLast(telephoneNumber.toString());
					}else
					{
						tempList.addLast(telephoneNumber.toString());
					}
					
				}else if(tempList.size()>0)
				{
					StringBuffer telSeq = new StringBuffer(tempList.getFirst().toString());
					//String finalSeq = ((Long)tempList.getLast()).toString().substring(6, 10);
					telSeq.append("-");
					telSeq.append(tempList.getLast().toString().substring(6, 10));
					tnSummarySorted.add(new TestVO(prevLocationName, prevAddress, telSeq.toString(), prevTnType, prevTnCategory));
					tempList.clear();
					
				}
				
			}else
			{
				if(tempList.size()>0)
				{
					StringBuffer telSeq = new StringBuffer(tempList.getFirst().toString());
					//String finalSeq = ((Long)tempList.getLast()).toString().substring(6, 10);
					telSeq.append("-");
					telSeq.append(tempList.getLast().toString().substring(6, 10));
					tnSummarySorted.add(new TestVO(prevLocationName, prevAddress, telSeq.toString(), prevTnType, prevTnCategory));
					tempList.clear();
				}else
				{
					tnSummarySorted.add(new TestVO(prevLocationName, prevAddress, prevTelephoneNumber.toString(), prevTnType, prevTnCategory));
				}
				
			}
			prevLocationName = locationName;
			prevAddress = address;
			prevTelephoneNumber = telephoneNumber;
			prevTnType = tnType;
			prevTnCategory = tnCategory;
		}
		System.out.println(tnSummarySorted);
		//Collections.sort(tnSummary);
	}
}












