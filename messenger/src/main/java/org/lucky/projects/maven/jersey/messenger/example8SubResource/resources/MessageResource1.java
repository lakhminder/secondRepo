package org.lucky.projects.maven.jersey.messenger.example8SubResource.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.server.Uri;
import org.lucky.projects.maven.jersey.messenger.example8SubResource.Exception.DataNotFoundException;
import org.lucky.projects.maven.jersey.messenger.example8SubResource.model.Message;
import org.lucky.projects.maven.jersey.messenger.example8SubResource.model.MessageBean;
import org.lucky.projects.maven.jersey.messenger.example8SubResource.service.MessageService;

/**
 *see addMessage
 *
 *For exception handling see getMessage
 *
 */
@Path("/example8/statusAndHeader")
public class MessageResource1 {
	
	MessageService messageService = new MessageService(); 
		
	/**
	 * Use Response Object to be return with own status and other stuff
	 * See the header formation with Location key
	 * 
	 * 
	 */
	
	/*@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message){
		Message newMessage = messageService.addMessage(message);
		
		return Response.status(Status.CREATED)
				.entity(newMessage)
				//.header("Location", "test") // => returns http://localhost:8080/messenger/webapi/example8/test
				.header("Location", "/test")  // => http://localhost:8080/test
				.build();		
		
	}*/
	
	/**
	 * Response.created = status created & set header Location to passed URI 
	 * 
	 * Note use of @Context UriInfo
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException{
		Message newMessage = messageService.addMessage(message);
		
		System.out.println(uriInfo.getAbsolutePath());
		URI locationUri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();
		
		return Response.created(locationUri)
				.entity(newMessage)
				.build();		
		
	}
	
	@GET
	@Path("jsonMessages")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam MessageBean bean){
		if(bean.getYear() > 0)
			return messageService.getAllMessagesForyear(bean.getYear());
		else if (bean.getStart() >= 1 && bean.getPageSize() > 0)
			return messageService.getAllMessagesPaginated(bean.getStart(), bean.getPageSize());
		
		return messageService.getAllMessages();
	}
	
	@Path("/{messageId}/comments") 
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
	
	/**
	 * Refer ErrorMessage.java and DataNotFoundExceptionMapper.java
	 * 
	 * Use WebApplicationException if need to form Exception already known by Jersey so that we need not tell jersey through mappers
	 * (disable generic mapper to run this)
	 * 
	 * check WebApplicationException constructor which take Response, Status etc
	 * Also subclasses of WebApplicationException like NotFoundException which is == to WebApplicationException(Status.NOT_FOUND)
	 * 
	 */
	@GET
	@Path("{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id){
		Message msg = messageService.getMessage(id);
		if (msg == null){
			throw new DataNotFoundException("Msg do not Exist!!");
		}
		
		/*if (msg == null){
		 * throw new WebApplicationException(Response.status(Status.NOT_FOUND).build());
		}*/
		
		return msg;
		
	}
	
}
