package org.lucky.projects.maven.jersey.messenger.example6PaginationAndFiltering.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lucky.projects.maven.jersey.messenger.example6PaginationAndFiltering.model.Message;

public class DBStub {
	
	private static Map<Long, Message> messages = new HashMap<>();
	
		
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	

}
