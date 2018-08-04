package org.lucky.hibernate.example4;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/*
 * @Transient tells hibernate not to use that property to insert data in DB
 * Also transient and static instance variables will not get stored in DB
 * 
 * @Temporal is used to specify part of date to be saved
 * 
 * @Lob is used to specify Large object
 *  For String it will be CLOB and for Byte it will be BLOB
 */

@Entity 
@Table (name="USER_DETAILS3")
public class User {
	
	private int userId;	
	private String userName;
	private Date joinDate;
	private String address;
	
	private String Description;
	
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
	@Temporal (TemporalType.DATE)
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	@Transient
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Lob
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

}
