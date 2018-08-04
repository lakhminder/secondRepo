package org.lucky.rest.advanced.example2Singleton;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Resources are request scope i.e per request
 * however to change to singleton add @Singleton
 * 
 *
 */

@Path("/eg2/resPath")
@Singleton
public class MyResource {
	
	private int count = 0;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages(){
		
		return "Sample Test Worked!" + count++ ;
	}
}
