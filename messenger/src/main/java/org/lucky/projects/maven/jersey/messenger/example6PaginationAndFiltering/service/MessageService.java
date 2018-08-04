package org.lucky.projects.maven.jersey.messenger.example6PaginationAndFiltering.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.lucky.projects.maven.jersey.messenger.example6PaginationAndFiltering.db.DBStub;
import org.lucky.projects.maven.jersey.messenger.example6PaginationAndFiltering.model.Message;
public class MessageService {
	
	private Map<Long, Message> messages = DBStub.getMessages();
	//private Map<String, Message> profiles = DBStub.getProfiles();
	
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
	
	public Message removeMessage(long id){			
		return messages.remove(id);
	}
	
	public List<Message> getAllMessagesForyear(int year){
		List<Message> msgListForYear = new ArrayList<Message>();
		Calendar calendar = Calendar.getInstance();
		for(Message message : messages.values()){
			calendar.setTime(message.getCreated());
			if(calendar.get(Calendar.YEAR) == year)
				msgListForYear.add(message);			
		}
		return msgListForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int pageSize){
		List<Message> msgList = new ArrayList<Message>(messages.values());
		if(start + pageSize > msgList.size())
			return new ArrayList<Message>();
		return msgList.subList(start, start + pageSize); //Logic can be improved though
	}
}
