package org.lucky.projects.maven.jersey.messenger.example8SubResource.Exception;

public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException(String msg) {
	super(msg);
}
	
}
