package org.lucky.hibernate.example3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * @Column above getter uses get*() to save the field in DB
 * @Column above property itself uses the filed to save in DB
 */

@Entity (name="USER_DETAILS3")
public class User {
	
	private int userId;
	
	private String userName;
	
	@Id
	@Column (name="USER_ID")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column (name="USER_NAME")
	public String getUserName() {
		return userName + "222";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
