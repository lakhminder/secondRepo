package org.lucky.projects.maven.jersey.messenger.example7ParamAnnotations.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.lucky.projects.maven.jersey.messenger.example7ParamAnnotations.model.Message;
import org.lucky.projects.maven.jersey.messenger.example7ParamAnnotations.model.MessageBean;
import org.lucky.projects.maven.jersey.messenger.example7ParamAnnotations.service.MessageService;

/**
 *Use @QueryParam to capture parameters passed in url
 *Pagination/filter logic shud be intrinsic to resource method
 *
 *check getMessages()
 *
 */
@Path("/example7")
public class MessageResource {
	
	MessageService messageService = new MessageService(); 

	/**
	 * Apart from @QueryParam & @PathParam we have following annotations as well:
	 * @MatrixParam : in url /example7/messages;param=value
	 * @HeaderParam : part of header
	 * @CookieParam : to read cookies
	 * @FormParam : rarely used, to get html form parameters
	 * 
	 * see getParamsUsingContext
	 * @Context is used when not sure about the params and want to iterate over all params
	 * @UriInfo for URLs and @HttpHeaders for header information/params
	 * 
	 * see getMessages() /jsonMessages for @BeanParam
	 * see MessageBean.java
	 * 
	 */
	
	
	@GET
	@Path("messages")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages(@MatrixParam("matrixParam") String mtParam,
									@HeaderParam("headerParam") String hdParam,
									@CookieParam("cookieParam") String ckParam){
		
		return "matrixParam:"  + mtParam + 
				"headerParam:" + hdParam +
				"cookieParam:" + ckParam;
	}
	
	@GET
	@Path("context")
	@Produces(MediaType.TEXT_PLAIN)
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers ){
		System.out.println(uriInfo.getAbsolutePath());
		System.out.println(headers.getCookies());
		return "See the SOS";
	}
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year,
									@QueryParam("start") int start,
									@QueryParam("size") int pageSize){
		if(year > 0)
			return messageService.getAllMessagesForyear(year);
		else if (start >= 1 && pageSize >= 0)
			return messageService.getAllMessagesPaginated(start, pageSize);
		
		return messageService.getAllMessages();
	}*/
	
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
}
