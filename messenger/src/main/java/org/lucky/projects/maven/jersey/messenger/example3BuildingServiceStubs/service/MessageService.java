package org.lucky.projects.maven.jersey.messenger.example3BuildingServiceStubs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.lucky.projects.maven.jersey.messenger.example3BuildingServiceStubs.db.DBStub;
import org.lucky.projects.maven.jersey.messenger.example3BuildingServiceStubs.model.Message;
public class MessageService {
	
	private Map<Long, Message> messages = DBStub.getMessages();
	
	public MessageService(){
		Message m1 = new Message(1, "m1", "author");
		Message m2 = new Message(2, "m2", "author");
		messages.put(1L, m1);
		messages.put(2L, m2);
	}

	public List<Message> getAllMessages(){				
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if (message.getId() <= 0)
			return null;
		else
			messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(Message message){			
		return messages.remove(message.getId());
	}
}
