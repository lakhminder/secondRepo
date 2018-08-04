package org.lucky.rest.advanced.example5MessageBodyWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 * Register with @Provider and implements MessageBodyWriter
 * MessageBodyWriter canbe defined per MediaType using @Produces(MediaType.TEXT_PLAIN)
 * implement MessageBodyReader for reading the message from Rest/Client
 *
 * Jersey called isWriteable to see if there is any MessageBodyWriter for type Date and MediaType.TEXT_PLAIN
 * if not able to find it will throw runtime error 
 * SEVERE: MessageBodyWriter not found for media type=text/plain, type=class java.util.Date, genericType=class java.util.Date.
 * 
 * in writeTo method Write back to EntityStream that will be sent back
 *
 */
@Provider
@Produces(MediaType.TEXT_PLAIN)
//@Produces(MediaType.APPLICATION_JSON)
public class DateMessageBodyWriter implements MessageBodyWriter<Date>{

	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return Date.class.isAssignableFrom(type);
		
	}

	@Override
	public long getSize(Date t, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public void writeTo(Date date, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException,
			WebApplicationException {
		// Write back to EntityStream that will be sent back
		entityStream.write(date.toString().getBytes());
	}

	
}
