package org.lucky.rest.advanced.example7Filters;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;
/**
 * Implementing basic auth to provide authentication security
 * to resource url containing *secured*
 * refer ContainerRequestFilter java docs for more elegant way of applying filter to 
 * specific resource using name binding
 * 
 * To make a request using postman add basic auth in header
 * 
 * In basic auth each request contains the <user>:<passwd> in header 
 * This is base64Encoded to handle non HTTP compatible characters
 * user:passwd base64 encoding => xyz=
 * Header below
 * Authorization => Basic xyz=
 * 
 * There are Interceptor entity as well in JAXRS which deals with intercepting the message payload.
 * So filters are used to intercept message header while interceptors are used to intercept message payload
 * Eg for Interceptors is Gzip output stream as below
 * public class GZIPWriterInterceptor implements WriterInterceptor{
 * 
 * @Override
 * public void aroundWriteTo(WriterInterceptorContext context) throws Exception{
 * 		final OutputStream outputStream = context.getOutputStream();
 * 		context.setOutputStream(new GZIPOutputStream(outputStream));
 * 		context.proceed();	
 * 	}
 * }
 * 
 * Moreover there are client side Filters and interceptors too
 * refer tut 5.1 if needed
 * refer tut 5.2 for JAXRS and EJBs
 */
@Provider
public class SecurityFilter implements ContainerRequestFilter{

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_BASIC = "Basic ";
	private static final String SECURED_URL = "secured";
	
	
	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		if(requestContext.getUriInfo().getPath().contains(SECURED_URL)){// This can be done by name binding as well
			String authToken = requestContext.getHeaderString(AUTHORIZATION_HEADER_KEY);
			if(authToken != null && !authToken.equals("")){
				authToken = authToken.replaceFirst(AUTHORIZATION_BASIC, "");
				//use any Base64 utility... here jersey one
				String decodedString = Base64.decodeAsString(authToken);
				StringTokenizer stringTokenizer = new StringTokenizer(decodedString,":");
				String user = stringTokenizer.nextToken();
				String passwd = stringTokenizer.nextToken();
				
				if("user".equals(user) && "passwd".equals(passwd)){
					return;//continue with flow
				}
				
			}
			//For unauthorized access need to abort the request
			Response unauthorizedResponse = Response
											.status(Response.Status.UNAUTHORIZED)
											.entity("User is not Authorized")
											.build();
			
			requestContext.abortWith(unauthorizedResponse);
		}
		
	}	


}
