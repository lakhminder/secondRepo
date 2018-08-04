package org.lucky.struts2.example7ModelDriven.action;

import org.lucky.struts2.example6ModelObject.Model.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	
	/*
	 * 	 see login.jsp as no need to specify the model
	 * <s:textfield label="Login ID" key="userId" />
	 * 
	 * @Override
	 *	public User getModel() {
	 *	return user;
	 *	}
	 * 
	 * Do need for initializing the User
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

	@Override
	public User getModel() {
		user = new User();
		return user;
	}
	
}
