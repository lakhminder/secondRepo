package parser;
//import javax.xml.parsers.*;
/*
 * 
 * Class Name 								Notes
 * gnu.xml.aelfred2.SAXDriver 				Lightweight non-validating parser; Free Software
 * gnu.xml.aelfred2.XmlReader 				Optionally validates; Free Software
 * oracle.xml.parser.v2.SAXParser 			Optionally validates; proprietary
 * org.apache.crimson.parser.XMLReaderImpl 	Optionally validates; used in JDK 1.4; Open Source
 * org.apache.xerces.parsers.SAXParser 		Optionally validates; Open Source
 * 
 */
import java.io.FileReader;

import org.xml.sax.helpers.DefaultHandler;
//import org.xml.sax.InputSource;
import org.xml.sax.Attributes;
//import org.apache.crimson.parser.XMLReaderImpl; //XML parser's SAX2 driver(class)
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.XMLReader; //XMLReader is the interface that an XML parser's SAX2 driver must implement.

class SaxParsing extends DefaultHandler
{
	private final static String INPUT_FILE="src/parser/xml/VLAN_MDA4.xml";
	//XMLReaderImpl x;
	public static void main (String args[])
	throws Exception
	{
		XMLReader xr = XMLReaderFactory.createXMLReader("org.apache.crimson.parser.XMLReaderImpl");		
		SaxParsing handler = new SaxParsing();
		xr.setContentHandler(handler);//handler is object of the class which extends DefaultHandler and overrides startElement,....
		xr.setErrorHandler(handler);
		//xr.parse(new InputSource(new FileReader(INPUT_FILE)));
		xr.parse(INPUT_FILE);
	}

	public void startElement (String uri, String name,
			String qName, Attributes atts)
	{
		System.out.println("Start element: " + name + "qname: " + qName);

	}


	public void endElement (String uri, String name, String qName)
	{
		System.out.println("END element: " + name + "qname: " + qName);
	}

	public void characters (char ch[], int start, int length)
	{
		//System.out.print("Characters:    \"");
		for (int i = start; i < start + length; i++) {
			switch (ch[i]) {
			case '\\':
				//System.out.print("\\\\");
				break;
			case '"':
				//System.out.print("\\\"");
				break;
			case '\n':
				//System.out.print("\\n");
				break;
			case '\r':
				//System.out.print("\\r");
				break;
			case '\t':
				//System.out.print("\\t");
				break;
			default:
				System.out.print(ch[i]);
			break;
			}
		}
		//System.out.print("\"\n");
	}

}