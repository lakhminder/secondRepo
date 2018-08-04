package org.lucky.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.transform.stream.StreamSource;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaElement;
import org.apache.ws.commons.schema.XmlSchemaType;

import javax.xml.namespace.QName;
public class XSDParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is;
		try {
			is = new FileInputStream("src/org/lucky/parser/sample.xsd");
		
		XmlSchemaCollection schemaCol = new XmlSchemaCollection();
		XmlSchema schema = schemaCol.read(new StreamSource(is));
		System.out.println(schema);
		XmlSchemaType schemaType = schema.getTypeByName(QName.valueOf("shipto"));
		XmlSchemaElement elem = schema.getElementByName("shipto");
		System.out.println(elem.getMetaInfoMap().size());
		//schemaType.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
