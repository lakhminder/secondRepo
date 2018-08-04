package WebServiceClient2;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.ServiceFactory;
import javax.xml.rpc.Service;
import javax.xml.rpc.Call;
import javax.xml.rpc.ParameterMode;
import javax.xml.namespace.QName;

public class SampleWebClient
{

	// TODO Auto-generated method stub
	public static void main(String[] args) throws ServiceException, MalformedURLException, RemoteException 
	{
		int a=10;
		int b=35;
		Integer x=new Integer(100);
		Integer y=new Integer(600);

	try
	{
		// Setup the global JAXM message factory    
	
	System.setProperty("javax.xml.soap.MessageFactory", "weblogic.webservice.core.soap.MessageFactoryImpl");    
	// Setup the global JAX-RPC service factory    
	System.setProperty( "javax.xml.rpc.ServiceFactory",      "weblogic.webservice.core.rpc.ServiceFactoryImpl");
	// create service factory    
	ServiceFactory factory = ServiceFactory.newInstance();
	// define qnames    
	
	String targetNamespace = "http://www.qwest.com/sampleWebService";
	
	
	QName serviceName =      new QName(targetNamespace, "SampleService");
	QName portName =      new QName(targetNamespace, "SampleServicePort");
	QName operationName = new QName("sum");
	URL wsdlLocation =      new URL("http://localhost:7001/webservice/sampleService?WSDL");
	
	String xml3550 = "Sample Request message";		
	
	String EventMessageRequest ="<?xml version='1.0' encoding='UTF-8'?><EventMessageRequest xsi:schemaLocation='http://www.cramer.com/qwest/cramerEvent CramerStatusEvents.xsd' xmlns='http://www.cramer.com/qwest/cramerEvent' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'><EventMessage><EventName>AdditionalUNIInfo</EventName><ComponentName>64/KXGS/000361//ACSO</ComponentName><ComponentType>UNI</ComponentType><ComponentID>144448</ComponentID><ServiceRequestID>1234</ServiceRequestID><TaskDetails><ProjectName>what goes here</ProjectName><ProjectType>UNI Installation</ProjectType><ProjectStatus>Open</ProjectStatus><TaskName>Modified Ethernet Bearer</TaskName><TaskStatus>Open</TaskStatus> </TaskDetails><Timestamp>11/16/2008 4:50:40 PM</Timestamp></EventMessage></EventMessageRequest>";
	// create service    
	Service service = factory.createService(wsdlLocation, serviceName);
	// create call    
	Call call = service.createCall(portName, operationName);		
	
	// invoke the remote web service		
	//String responseString = (String) call.invoke(new Object[]{"CramerEventMessageListener" , EventMessageRequest});
	Integer responseString = (Integer) call.invoke(new Object[]{x,y});
	System.out.println(responseString);
	}catch(Exception e)
	{
		e.printStackTrace();
	}

	}
}