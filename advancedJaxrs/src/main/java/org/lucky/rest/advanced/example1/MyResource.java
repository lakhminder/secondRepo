package org.lucky.rest.advanced.example1;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * To bootstrap either use Jersey servlet in web.xml as incase of messenger application
 * or simply Extends javax.ws.rs.core.Application (see MyApp)
 * 
 * 
 *
 */

@Path("/eg1/resPath")
public class MyResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages(){
		return "Sample Test Worked!";
	}
}
