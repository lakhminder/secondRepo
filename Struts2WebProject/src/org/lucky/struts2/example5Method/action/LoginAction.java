package org.lucky.struts2.example5Method.action;

public class LoginAction {
	
	/*
	 * can use wildcards in struts.xml
	 * different method than execute()
	 */
	private String userId;
	private String password;

	public String add(){
		System.out.println("*******Inside add()*********");
		
			return "success";
		
	}
	
	public String edit(){
		System.out.println("*******Inside edit()*********");
		
			return "success";
		
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
