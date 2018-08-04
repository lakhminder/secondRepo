package org.lucky.rest.advanced.example1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * 
 * Extending Application means that this is an JAXRS application
 * It will scan all classes in classpath for @Path i.e resources and exposes them via myRestUrl/*
 *
 *Extract from Application documentation
 *===========================
 *Defines the components of a JAX-RS application and supplies additional
 * meta-data. A JAX-RS application or implementation supplies a concrete
 * subclass of this abstract class.
 * ==========================
 * No need to implement any of the method as Application is not declared abstract
 *  This scans for all classes in classpath.however to include/exclude some we can override 
 *  getClasses()
 *  
 *  Note doublebrace initialisation for HashSet
 */

@ApplicationPath("myRestUrl")
public class MyApp extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
        //return Collections.emptySet();
		Set classSet = null;
		try {
			classSet = new HashSet<Class<?>>(){{
				add(Class.forName("org.lucky.rest.advanced.example1.MyResource"));
				//add(Class.forName("org.lucky.rest.advanced.example1.MyResource1"));
			}};
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return classSet;
    }

}
