package org.lucky.projects.maven.jersey.messenger.example8SubResource.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 
 * @Provider is used to tell JaxRS to use this exception mappers incase exception of that type occurs 
 * 
 * see GenericExceptionMapper.java as well
 *
 */

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	/**
	 * This will return Tomcat exception page(HTML) with Our Status
	 */
	@Override
	public Response toResponse(DataNotFoundException ex) {
		// TODO Auto-generated method stub
		return Response.status(Status.NOT_FOUND)
				.build();
	}

	
}
