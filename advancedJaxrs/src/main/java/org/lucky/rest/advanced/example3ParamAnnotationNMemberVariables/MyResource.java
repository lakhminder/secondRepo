package org.lucky.rest.advanced.example3ParamAnnotationNMemberVariables;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Resources are request scope i.e per request
 * however to change to singleton add @Singleton
 * 
 * @PathParam & other params can be used with instance/member variables if all methods need them,
 * however it cannot be used with singleton
 */

@Path("/eg3/{pathParameter}/resPath")
//@Singleton
public class MyResource {
	
	@PathParam("pathParameter")
	private String pathParam;
	@QueryParam("queryParameter")
	private String queryParam;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages(){		
		return "pathParam:" +  pathParam + " and Query Param:" + queryParam;
	}
}
