package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.InputSource;

public class SampleTransformer {
	
	public void xsltTransform(InputSource xsltSource, javax.xml.transform.Source source, Result result){
		
	}

	public static void main(String[] args) throws Exception {
		String xmlFileName = "src/xml/";
		String xsltFileName = "src/xslt/";
		/*String xmlFileName = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><?xml-stylesheet type=\"text/xsl\" href=\"karan.xslt\"?><car><owner><name><first>karan</first><last>kapoor</last></name></owner></car>";
		String xsltFileName = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"><xsl:output method=\"xml\"/>"+
							"<xsl:template match=\"/\"><business><xsl:value-of select=\"car/owner/name/first\"/></business><xsl:value-of select=\"car/owner/name/last\"/></xsl:template></xsl:stylesheet>";*/
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.println("File Name: ");
		String fileName = bufferedReader.readLine();
		xmlFileName = xmlFileName + fileName + ".xml";
		xsltFileName = xsltFileName + fileName + ".xslt";
		File xmlFile = new File(xmlFileName);
		File xsltFile = new File(xsltFileName);
		Source xmlSource = new StreamSource(xmlFile);
		Source xsltSource = new StreamSource(xsltFile);
		/*Source xmlSource = new StreamSource(new StringReader(xmlFileName));
		Source xsltSource = new StreamSource(new StringReader(xsltFileName));*/
		TransformerFactory factory = TransformerFactory.newInstance();
		Templates templates = factory.newTemplates(xsltSource);
		Transformer trans = templates.newTransformer();
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		trans.transform(xmlSource, result);
		
		System.out.println("result : " + writer.toString());
	}

}
