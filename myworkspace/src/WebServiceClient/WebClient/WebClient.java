package WebServiceClient.WebClient;

import com.lucky.sampleService.client.SampleService;
import com.lucky.sampleService.client.SampleService_Impl;
import com.lucky.sampleService.client.SampleServicePort;

public class WebClient
{
	public static void main(String a[])
	{
		try
		{//String result;
		String wsdlUrl = "http://localhost:7001/webservice/sampleService?WSDL"; 
	    SampleService service = new SampleService_Impl( wsdlUrl );
	    SampleServicePort port = service.getSampleServicePort();

	    int result = port.sum(3,5 );
	    System.out.println(result);
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}