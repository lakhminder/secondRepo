package org.lucky.struts2.example3Login.action;

import org.lucky.struts2.example2.service.TutorialBS;

public class LoginAction {
	
	/*
	 * Call login.jsp first 
	 * 
	 * Best Practices for Struts2
	 * 1) implement interface com.opensymphony.xwork2.Action
	 * 		to include standard constants
	 * 2) use <include file="struts-contacts.xml" /> in main struts.xml
	 * 3) use action to redirect to JSP instead using the JSP directly in browser as follows
	 * 		<package name="example3" namespace="/example3" extends="struts-default">
	 *	
	 *			<action name="loginPage">
	 *				<result >/example3/login.jsp</result>
	 *			</action>
	 *		</package>
	 * 4) can use wildcards in struts.xml
	 */
	private String userId;
	private String password;

	public String execute(){
		if(getUserId().equals("Lucky") && getPassword().equals("Lucky"))
			return "success";
		else
			return"failure";
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}

	
}
