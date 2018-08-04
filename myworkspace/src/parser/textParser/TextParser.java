package parser.textParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser 
{
	private final static String BASE_FOLDER = "C:/Lucky/code_backup/2011/June/CPE_IQ_Data_Bundle/test";
	//private final static String BASE_FOLDER = "C:/Lucky/code_backup/2011/June/CPE_IQ_Data_Bundle/test/Two Rivers Bank & Trust/changes for 4320 Westown Pkwy 100110.txt";
	
	
	public TextParser()
	{
		
	}
	
	public void scan()
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
			baseDirectory = new File(BASE_FOLDER);
			subDirList = baseDirectory.listFiles();
			for(int i=0;i < subDirList.length;i++)
			{
				currentFile = subDirList[i];
				innerDirList = currentFile.listFiles();
				for(int j=0;j<innerDirList.length;j++)
				{
					if(innerDirList[j].isDirectory() && 
							(innerDirList[j].getName().indexOf("running") != -1 || innerDirList[j].getName().indexOf("Running") != -1))
					{
						dirList.add(innerDirList[j].getAbsoluteFile());
					}
				}

				//System.out.println(subDirList[i].getName());
				//System.out.println(subDirList[i].getCanonicalPath());
				//System.out.println(subDirList[i].getAbsolutePath());
			}
			for(Iterator itr = dirList.iterator();itr.hasNext();)
			{
				currentFile = (File)itr.next();
				fileList = currentFile.listFiles();
				for(int i=0; i<fileList.length;i++)
				{
					if(fileList[i].getName().endsWith(".txt"))
					{
						currentFile = fileList[i];
						System.out.println("\n" + currentFile.getAbsolutePath());
						//System.out.println(new Date(currentFile.lastModified()));
						System.out.println(new java.sql.Date(currentFile.lastModified()));
						
						fr=new FileReader(currentFile);			
						br = new BufferedReader(fr);
						
						while((str=br.readLine())!=null)
							//while((str=is.read())!=-1)
							{
							matcher.reset( str ); //reset the input
					        if ( matcher.find() ) {
					          String msg = "Line : " + matcher.group() ;
					          System.out.println(msg);
					        }

								/*if((index=str.indexOf("description")) != -1)
								{
									System.out.println(str.split("description")[1]);
									//System.out.println(str.indexOf("description"));
								}*/
							
							
															
							}
					}
				}
				
			}
			/*fr=new FileReader(BASE_FOLDER);			
			br = new BufferedReader(fr);
			
			while((str=br.readLine())!=null)
				//while((str=is.read())!=-1)
				{
					
					if((index=str.indexOf("description")) != -1)
					{
						System.out.println(str.split("description")[1]);
						//System.out.println(str.indexOf("description"));
					}
				
				sTokenizer= new StringTokenizer(str);
					while(sTokenizer.hasMoreTokens())
					{
						if(sTokenizer.nextToken().equalsIgnoreCase("description"))
						{
							System.out.println(sTokenizer);
						}
					}
												
				}*/
		}
		/*catch(FileNotFoundException fe)
		{
			fe.printStackTrace();
		}*/catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				fr.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
