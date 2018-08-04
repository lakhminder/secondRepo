package org.lucky.projects.maven.jersey.messenger.example2.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.lucky.projects.maven.jersey.messenger.example2.model.Message;
public class MessageService {

	public List<Message> getAllMessages(){
		Message m1 = new Message(1, "m1", "author");
		Message m2 = new Message(2, "m2", "author");
		List<Message> list = new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		
		return list;
	}
}
