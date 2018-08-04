package org.lucky.projects.maven.jersey.messenger.example3BuildingServiceStubs.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.lucky.projects.maven.jersey.messenger.example3BuildingServiceStubs.model.Message;
import org.lucky.projects.maven.jersey.messenger.example3BuildingServiceStubs.service.MessageService;

/**
 * refer Message.java for conversion to xml using jaxb(bundled wtih java only)
 * DBStub is created to simulate in memory DB Stub for CRUD operations
 * refer messageService.java
 *
 */
@Path("/example3/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService(); 

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
}
