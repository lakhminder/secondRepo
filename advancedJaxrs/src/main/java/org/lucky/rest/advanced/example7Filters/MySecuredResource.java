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
 *  refer SecurityFilter.java 
 */

@Path("/eg7/secured")
public class MySecuredResource {
		
	@GET
	//This would be reffered by client by using Accepts header key
	@Produces(value = {MediaType.TEXT_PLAIN, "text/shortDate"})
	//@Produces(MediaType.APPLICATION_JSON)
	public String getMessages(){		
		return "Secured Hello World";
	}
	
	
}
