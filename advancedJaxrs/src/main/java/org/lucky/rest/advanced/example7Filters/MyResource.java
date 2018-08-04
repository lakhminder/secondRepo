package org.lucky.rest.advanced.example7Filters;

import java.util.Date;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Filters are kind of request and response interceptors for applying cross-cutting concerns.
 * implement ContainerResponseFilter for response and ContainerRequestFilter for request
 * 
 * refer PoweredByResponseFilter.java and LoggingFilter.java
 */

@Path("/eg7/test")
public class MyResource {
		
	@GET
	//This would be reffered by client by using Accepts header key
	@Produces(value = {MediaType.TEXT_PLAIN, "text/shortDate"})
	//@Produces(MediaType.APPLICATION_JSON)
	public String getMessages(){		
		return "Hello World";
	}
	
	
}
