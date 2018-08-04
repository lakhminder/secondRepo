package org.lucky.struts2.example4ActionSupport.action;

import org.apache.commons.lang.StringUtils;
import org.lucky.struts2.example2.service.TutorialBS;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	/*
	 * ActionSupport provides validation support + static constants(see source code)
	 * 
	 * Following entry in struts.xml shows the input page and 
	 * redirects to this incase of any validation errors
	 * 
	 * <result name="input">/example4/login.jsp</result>
	 */
	private String userId;
	private String password;
	
	public void validate() {
		if(StringUtils.isEmpty(getUserId())){
			addFieldError( "userId", "UserId is Blank");
		}
		if(StringUtils.isEmpty(getPassword())){
			addFieldError( "password", "password is Blank");
		}
    }

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
