package org.lucky.struts2.example6ModelObject.action;

import org.lucky.struts2.example6ModelObject.Model.User;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	/*
	 * 	 see login.jsp
	 * <s:textfield label="Login ID" key="user.userId" />
	 * 
	 * Notice: No need for initializing the User
	 */
	private User user;

	public String execute(){
		if(user.getUserId().equals("Lucky") && user.getPassword().equals("Lucky"))
			return "success";
		else
			return"failure";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	

	
}
