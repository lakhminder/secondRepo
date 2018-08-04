package org.lucky.projects.maven.jersey.messenger.example5ReturningJSONResponse.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.lucky.projects.maven.jersey.messenger.example5ReturningJSONResponse.model.Message;
import org.lucky.projects.maven.jersey.messenger.example5ReturningJSONResponse.service.MessageService;

/**
 * refer pom.xml to include JSON dependency that was shipped alongwith this project archtype
 * just uncomment that
 * 
 * refer addMessage() for POST method and usage of @Consumes
 * while sending post method remeber to add header as 
 * Content-Type		 application/json
 * 
 * refer update and delete method as well
 * 
 * You can put @Produces/@Consumes(MediaType.APPLICATION_JSON) at class level if every method indeed needs that
 * 
 * Also you can use @Produces(value = {MediaType.APPLICATION_JSON,MediaType.TEXT_XML}) to specify that it produces both JSON and XML
 * client specifies following in header 
 * Accepts	application/json
 * or
 * Accepts	text/xml
 * 	
 * Accepts => @Produces
 * Content-Type => @Consumes
 * 
 * Request is mapped to @Path + RequestType(GET/PUT) + Accepts(xml/Json) value in header(what client wants)
 *
 */
@Path("/example5/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService(); 

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces(value = {MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	/*
	 // Works when Accepts = application/json	 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces(value = {MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	public List<Message> getJsonMessages(){
		return messageService.getAllMessages();
	}
	
	
	//  Works when Accepts = text/xml
	@GET
	@Produces(MediaType.TEXT_XML)
	//@Produces(value = {MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	public List<Message> getXmlMessages(){
		return messageService.getAllMessages();
	}
	*/
	
	
	@GET
	@Path("{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id){
		return messageService.getMessage(id);
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		//Always set id from URL while updating existing record
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id){
		messageService.removeMessage(id);
	}
}
