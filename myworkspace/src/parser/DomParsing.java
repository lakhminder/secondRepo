package parser;

import java.util.*;
import java.io.*;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParsing 
{
	String xmlFileName = "src/parser/xml/lookup.xml";
	Map lookupMap = new LinkedHashMap();
	public void parseXml()throws Exception
	{
		//URL url = new URL(xmlFileName);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(false);
		DocumentBuilder builder = factory.newDocumentBuilder();
		//Document doc = builder.parse(url.openStream());
		Document doc = builder.parse(new FileInputStream(xmlFileName));
		Element root = doc.getDocumentElement();
		NodeList nodeList = root.getElementsByTagName("interface-lookup");
		System.out.println("NODE LIST : " + nodeList.toString());
		if(nodeList != null && nodeList.getLength() > 0)
		{
			for(int index = 0;index<nodeList.getLength();index++)
			{
				Node node = nodeList.item(index);
				String originatorName = ((Element)node).getElementsByTagName("originator").item(0).getFirstChild().getNodeValue();				
				String xsltName = ((Element)node).getElementsByTagName("xslt").item(0).getFirstChild().getNodeValue();				
				lookupMap.put(originatorName, xsltName);
			}
		}
		Set key =lookupMap.keySet();
		Iterator itr=key.iterator();
		while(itr.hasNext())
		{
			String k=(String)itr.next();
			System.out.println("Key: " + k + " 	Value: " + lookupMap.get(k));
		}
	}
	
}