package org.lucky.rest.advanced.example6RestClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 
 * This can be used when we just need to build/prepare the request and then call/invoke it afterwards.
 *
 *buildGet gives the invocation object back which can be invoked at later time
 *
 */
public class RestClientUsingInvocation {

	public static void main(String[] args) {
		Invocation invocation = prepareRequestForMessageByYear(2015);
		Response response = invocation.invoke();
		System.out.println(response.getStatus());

	}
	
	public static Invocation prepareRequestForMessageByYear(int year){
		Client client = ClientBuilder.newClient();
		
		return client.target("http://localhost:8080/messenger/webapi/")
		.path("example7/jsonMessages/")
		.queryParam("year", year)
		.request(MediaType.APPLICATION_JSON)
		.buildGet();
		
	}

}
