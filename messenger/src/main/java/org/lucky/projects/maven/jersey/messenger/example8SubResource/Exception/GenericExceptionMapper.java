package org.lucky.projects.maven.jersey.messenger.example8SubResource.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.lucky.projects.maven.jersey.messenger.example8SubResource.model.ErrorMessage;

/**
 * invoke this to get runtime Exception that will get mapped by this class
 * http://localhost:8080/messenger/webapi/example8/statusAndHead 
 *
 *ErrorMessage as entity is returned instead of Tomcat html
 */

//Enable it to test
//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	/**
	 * This will return our JSON(Object) with Our Status
	 */
	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500);
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}

	
}
