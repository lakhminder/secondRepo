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
 * see @Produces("text/shortDate") for defining own mediaType
 * 
 *
 */
@Provider
@Produces("text/shortDate")
//@Produces(MediaType.APPLICATION_JSON)
public class ShortDateMessageBodyWriter implements MessageBodyWriter<Date>{

	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return Date.class.isAssignableFrom(type);
		//return false;
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
		String shortDate = date.getDate() + "-" + date.getMonth() + "-" + date.getYear();
		entityStream.write(shortDate.getBytes());
	}

	
}
