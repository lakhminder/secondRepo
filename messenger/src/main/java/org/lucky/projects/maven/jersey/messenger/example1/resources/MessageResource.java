package org.lucky.projects.maven.jersey.messenger.example1.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @Path is used to define the resource uri
 * @Get used to define which HTTP method request it entertains
 * @Produces define the response type
 * refer web.xml for folder to scan for resource uri's
 * 
 *
 */
@Path("/messages")
public class MessageResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages(){
		return "Hello World";
	}
}
