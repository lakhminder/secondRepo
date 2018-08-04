package org.lucky.hibernate.example6embeddedObject;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
 *@Embeded to specify the referred object to be part of same Table in DB
 *or use Embeddable in Address.java
 *
 *@EmbeddedId is to be used if primary key in DB is composite i.e @Embedded + @Id 
 */

@Entity 
@Table (name="USER_DETAILS6")
public class User6 {
	@Id
	@Column (name="USER_ID")
	//@GenericGenerator(name = "generator1", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "lucky_sequence"))
	@SequenceGenerator (name="generator2",sequenceName="lucky_sequence")
	@GeneratedValue (generator="generator2")
	private int userId;
	@Column (name="USER_NAME")
	private String userName;
	@Temporal (TemporalType.DATE)
	private Date joinDate;
	@Embedded
	private Address homeAddress;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride (name="street",column=@Column(name="office_street_name")),
	@AttributeOverride (name="city",column=@Column(name="office_city_name")),
	@AttributeOverride (name="state",column=@Column(name="office_state_name")),
	@AttributeOverride (name="pinCode",column=@Column(name="office_pinCode_name"))
	})
	private Address officeAddress;
	@Lob
	private String Description;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName + "222";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getWorkAddress() {
		return officeAddress;
	}
	public void setWorkAddress(Address workAddress) {
		this.officeAddress = workAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

}
