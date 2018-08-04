package org.lucky.rest.advanced.example4ParamConverters;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.lucky.rest.advanced.example4ParamConverters.model.MyDate;

/**
 * to convert string Parameter to custom Objects like query/path param ParameterConverter is used
 * Jersey provides out of box ParamConverterProvider => ParamConverter for default data types conversions like String to int etc
 * For custom We need to provide on our own
 * 
 * So there are series of ParamConverterProvider to which Jersey asks if they have converter for dataType say int/MyDate
 * ParamConverterProvider() provides the ParamConverter if it has for that dataType which is used to 
 * convert String to desired DataType
 * 
 * Custom providers need to be registered with @Provider (happens at server startup)
 * refer MyDateConverterProvider.java
 */

@Path("/eg4/{dateString}")
//@Singleton
public class MyResource {
	
	
	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getDate(@PathParam("dateString") String date){		
		return date;
	}*/
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getDate(@PathParam("dateString") MyDate date){		
		return date.toString();
	}
}
