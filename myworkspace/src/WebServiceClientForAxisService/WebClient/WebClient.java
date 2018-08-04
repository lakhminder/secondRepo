package WebServiceClientForAxisService.WebClient;

//import com.lucky.sampleService.client.SampleService;
//import com.lucky.sampleService.client.SampleService_Impl;
//import com.lucky.sampleService.client.SampleServicePort;

import com.lucky.sampleService.clientForAxis.CodServiceService_Impl;
import com.lucky.sampleService.clientForAxis.CodService_Stub;
import com.lucky.sampleService.clientForAxis.CodService;
import com.lucky.sampleService.clientForAxis.CodServiceService;

public class WebClient
{
	public static void main(String a[])
	{
		try
		{
			String result;
			String request = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
					"<GenericBtlByAttributeRequest xmlns=\"http://www.qwest.com/XMLSchema\" " +
					"xmlns:qb=\"http://www.qwest.com/XMLSchema/BIM\"><ObjectType>Session Billed Trunk Group</ObjectType>" +
					"<CustomerAccountId>52475064</CustomerAccountId><AttributeNode><AttributeName>TRUNK_GRP_NM</AttributeName><AttributeValue>ROLL4382PL02</AttributeValue></AttributeNode></GenericBtlByAttributeRequest>";	
						
			String wsdlUrl = "http://lxdenvmtc033.dev.qintra.com:55861/axis/services/CodService?WSDL"; 
			//CodServiceService service = new CodServiceService_Impl( wsdlUrl);
			//CodService_Stub stub = (CodService_Stub)service.getPort(CodService_Stub.class);
			CodServiceService_Impl service = new CodServiceService_Impl();
			//service._setProperty(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY,wsdlUrl);
			CodService stub = service.getCodService();
			result = stub.getGenericBTLByAttribute(request);
			//service.context().currentContext().getHeader().
			//SampleServicePort port = service.getSampleServicePort();

			//int result = port.sum(3,5 );
			System.out.println(result);
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}