package org.lucky.projects.maven.jersey.messenger.example2.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.lucky.projects.maven.jersey.messenger.example2.model.Message;
import org.lucky.projects.maven.jersey.messenger.example2.service.MessageService;

/**
 * refer Message.java for conversion to xml using jaxb(bundled wtih java only)
 * 
 *
 */
@Path("/example2/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService(); 

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
}
