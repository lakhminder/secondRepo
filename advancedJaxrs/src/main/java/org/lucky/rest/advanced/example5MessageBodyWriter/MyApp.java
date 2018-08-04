package org.lucky.rest.advanced.example5MessageBodyWriter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Restricting to only respective folder else all gets registered with each example*\MyApp
 * Note that @Provider classes also need to be set here if using getClasses()  
 * 
 */

@ApplicationPath("myRestUrl5")
public class MyApp extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
        //return Collections.emptySet();
		Set classSet = null;
		try {
			classSet = new HashSet<Class<?>>(){{
				add(Class.forName("org.lucky.rest.advanced.example5MessageBodyWriter.MyResource"));
				add(Class.forName("org.lucky.rest.advanced.example5MessageBodyWriter.DateMessageBodyWriter"));				
				add(Class.forName("org.lucky.rest.advanced.example5MessageBodyWriter.ShortDateMessageBodyWriter"));
			}};
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return classSet;
    }

}
