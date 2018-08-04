package org.lucky.projects.maven.jersey.messenger.example6PaginationAndFiltering.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.lucky.projects.maven.jersey.messenger.example6PaginationAndFiltering.model.Message;
import org.lucky.projects.maven.jersey.messenger.example6PaginationAndFiltering.service.MessageService;

/**
 *Use @QueryParam to capture parameters passed in url
 *Pagination/filter logic shud be intrinsic to resource method
 *
 *check getMessages()
 *
 */
@Path("/example6/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService(); 

	/**
	 * Logic can be improved for handling pagination/filter logic
	 * @param year
	 * @param start
	 * @param pageSize
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year,
									@QueryParam("start") int start,
									@QueryParam("size") int pageSize){
		if(year > 0)
			return messageService.getAllMessagesForyear(year);
		else if (start >= 1 && pageSize >= 0)
			return messageService.getAllMessagesPaginated(start, pageSize);
		
		return messageService.getAllMessages();
	}
	
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
