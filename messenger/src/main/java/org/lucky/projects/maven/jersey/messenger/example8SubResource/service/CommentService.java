package org.lucky.projects.maven.jersey.messenger.example8SubResource.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.lucky.projects.maven.jersey.messenger.example8SubResource.db.DBStub;
import org.lucky.projects.maven.jersey.messenger.example8SubResource.model.Comment;
import org.lucky.projects.maven.jersey.messenger.example8SubResource.model.Message;

/**
 * 
 * CommentService uses messageid as first input parameter for all methods as it is part of a message
 *
 */

public class CommentService {
	
	private Map<Long, Message> messages = DBStub.getMessages();
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
		
}
