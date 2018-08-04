package org.lucky.projects.maven.jersey.messenger.example4AccessingPathParam.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.lucky.projects.maven.jersey.messenger.example4AccessingPathParam.model.Message;
import org.lucky.projects.maven.jersey.messenger.example4AccessingPathParam.service.MessageService;

/**
 * refer getMessage method for accessing path param
 * http://localhost:8080/messenger/webapi/example4/messages/1
 * @PathParam is used to pass path variables as method parameters , type conversion is taken care by jersey/REST API
 *
 */
@Path("/example4/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService(); 

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") long id){
		return messageService.getMessage(id);
		
	}
}
