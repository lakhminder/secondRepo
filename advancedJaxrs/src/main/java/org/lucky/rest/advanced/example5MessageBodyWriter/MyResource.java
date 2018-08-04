package org.lucky.rest.advanced.example5MessageBodyWriter;

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
 * See DateMessageBodyWriter.java
 * 
 * We can even have custom media types by declaring it as string and having MessageBodyWriter/Reader for it
 * this can be used in versioning/handle different data types like CSV out of box
 * refer ShortDateMessageBodyWriter.java
 * 
 * client specifies following in header 
 * Accepts	text/plain
 * or
 * Accepts	text/shortDate
 */

@Path("/eg5/test")
//@Singleton
public class MyResource {
		
	@GET
	//This would be reffered by client by using Accepts header key
	@Produces(value = {MediaType.TEXT_PLAIN, "text/shortDate"})
	//@Produces(MediaType.APPLICATION_JSON)
	public Date getMessages(){		
		return new Date();
	}
	
	
}
