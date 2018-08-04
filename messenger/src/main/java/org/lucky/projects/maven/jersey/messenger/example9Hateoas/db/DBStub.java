package org.lucky.projects.maven.jersey.messenger.example9Hateoas.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import org.lucky.projects.maven.jersey.messenger.example9Hateoas.model.Message;
import org.lucky.projects.maven.jersey.messenger.example9Hateoas.model.Profile;

public class DBStub {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
		
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	

}
