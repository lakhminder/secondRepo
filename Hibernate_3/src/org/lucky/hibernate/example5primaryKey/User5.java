package org.lucky.hibernate.example5primaryKey;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/*
 *@GeneratedValue will use 'select hibernate_sequence.nextval from dual'
 *Use GenericGenerator for specific user sequence
 * or SequenceGenerator
 */

@Entity 
@Table (name="USER_DETAILS3")
public class User5 {
	
	private int userId;	
	private String userName;
	private Date joinDate;
	private String address;
	
	private String Description;
	
	@Id
	@Column (name="USER_ID")
	//@GenericGenerator(name = "generator1", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "lucky_sequence"))
	@SequenceGenerator (name="generator2",sequenceName="lucky_sequence")
	@GeneratedValue (generator="generator2")
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
