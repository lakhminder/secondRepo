package parser.textParser;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

public class Test
{
	URI uri = null;
	private final static String BASE_FOLDER = 
		//"file://151.116.101.128/eclipse/readme/readme_eclipse.html"; 
		//"file://velomp2a/CPEConfigs/Product/Data Bundle (formely Office Connect)/1 - B/21st Century Bank/Running Configs/blain_mn_041910.txt";
		///"file:////velomp2a/CPEConfigs/Product/Data%20Bundle%20(formely%20Office%20Connect)/1%20-%20B/21st%20Century%20Bank/Running%20Configs/blain_mn_041910.txt";
		"file:////velomp2a/CPEConfigs/Product/Data%20Bundle%20(formely%20Office%20Connect)/1%20-%20B/Bank%20Of%20The%20Southwest/Running%20Config/Roswell_NM_Netvanta3430_112009.txt";
		//"C:/Lucky/code_backup/2011/June/CPE_IQ_Data_Bundle/test/Two Rivers Bank & Trust/changes for 4320 Westown Pkwy 100110.txt";
	/*public Test()
	{
		FileReader fr=null;				
		BufferedReader br=null;
		StringTokenizer sTokenizer = null;
		String str = null;
		int index = -1;
		File baseDirectory = null;
		File subDirList[]= null;
		File innerDirList[]= null;
		File currentFile = null;
		ArrayList dirList = new ArrayList();
		File fileList[] = null;
		
		Pattern regexp = Pattern.compile(".*description.*");
	    Matcher matcher = regexp.matcher("");
	    try
	    {
	    	//fr=new FileReader(BASE_FOLDER);
	    	uri = new URI(BASE_FOLDER);
	    	fr=new FileReader(new File(uri));
	    	br = new BufferedReader(fr);

	    	StringBuffer sb = new StringBuffer("");
	    	while((str=br.readLine())!=null)
	    		//while((str=is.read())!=-1)
	    	{
	    		sb.append(str + "\n");
	    		
	    	}
	    	if (sb.length() != 0)
	    	{
	    		str = cvtLineTerminators(sb.toString());
	    	}
	    	matcher.reset( str ); //reset the input
    		if ( matcher.find() ) 
    		{
    			String msg = "Line : " + matcher.group() ;
    			System.out.println(msg);
    		}
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	// Convert \n and \r character sequences to their single character
	// equivalents
	public String cvtLineTerminators (String s)
	   {
	      StringBuffer sb = new StringBuffer (80);
	      int oldindex = 0, newindex;
	      while ((newindex = s.indexOf ("\\n", oldindex)) != -1)
	      {
	         sb.append (s.substring (oldindex, newindex));
	         oldindex = newindex + 2;
	         sb.append ('\n');
	      }
	      sb.append (s.substring (oldindex));
	      s = sb.toString ();
	      sb = new StringBuffer (80);
	      oldindex = 0;
	      while ((newindex = s.indexOf ("\\r", oldindex)) != -1)
	      {
	         sb.append (s.substring (oldindex, newindex));
	         oldindex = newindex + 2;
	         sb.append ('\r');
	      }
	      sb.append (s.substring (oldindex));
	      return sb.toString ();
	   }*/
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	
	public Test()
	{
		FileReader fr=null;				
		BufferedReader br=null;
		StringTokenizer sTokenizer = null;
		String str = null;
		int index = -1;
		File baseDirectory = null;
		File subDirList[]= null;
		File innerDirList[]= null;
		File currentFile = null;
		ArrayList dirList = new ArrayList();
		File fileList[] = null;
		
		String ip = null;
		String cbn = null;
		
		//Pattern regexp = Pattern.compile(".*description.*");
	    //Matcher matcher = regexp.matcher("");
	    try
	    {
	    	//fr=new FileReader(BASE_FOLDER);
	    	uri = new URI(BASE_FOLDER);
	    	fr=new FileReader(new File(uri));
	    	br = new BufferedReader(fr);

	    	//StringBuffer sb = new StringBuffer("");
	    	while((str=br.readLine())!=null)
	    		//while((str=is.read())!=-1)
	    	{
	    		/*matcher.reset( str ); //reset the input
	    		if ( matcher.find() ) 
	    		{
	    			String msg = "Line : " + matcher.group() ;
	    			System.out.println(msg);
	    		}*/
	    		
	    		if((index=str.indexOf("description")) != -1)
				{
	    			if(str.split("description").length > 1)
	    			{
	    				System.out.println(str.split("description")[1]);
	    				//System.out.println(str.indexOf("description"));
	    				if(str.split("description")[1].indexOf("DS") != -1)
	    				{
	    					cbn = str.split("description")[1];
	    					//look for IP address
	    					if((str=br.readLine())!=null)
	    					{
	    						if((index=str.indexOf("address")) != -1)
	    						{
	    							ip = str.split("address")[1];
	    							ip = ip.trim().split("\\s")[0];
	    						}
	    						System.out.println("CBN: " + cbn + " IP: " + ip);
	    					}
	    				}
	    			}
				}
	    		
	    	}
	    	
	    	
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	// Convert \n and \r character sequences to their single character
	// equivalents
	public String cvtLineTerminators (String s)
	   {
	      StringBuffer sb = new StringBuffer (80);
	      int oldindex = 0, newindex;
	      while ((newindex = s.indexOf ("\\n", oldindex)) != -1)
	      {
	         sb.append (s.substring (oldindex, newindex));
	         oldindex = newindex + 2;
	         sb.append ('\n');
	      }
	      sb.append (s.substring (oldindex));
	      s = sb.toString ();
	      sb = new StringBuffer (80);
	      oldindex = 0;
	      while ((newindex = s.indexOf ("\\r", oldindex)) != -1)
	      {
	         sb.append (s.substring (oldindex, newindex));
	         oldindex = newindex + 2;
	         sb.append ('\r');
	      }
	      sb.append (s.substring (oldindex));
	      return sb.toString ();
	   }
	
	
}