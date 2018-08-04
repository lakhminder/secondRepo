package org.lucky.hibernate.example17namedAndNativeQuery;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/*
 * For @NamedNativeQuery , we need to specify the result class
 */

@Entity 
@NamedQuery (name="UserDetails.ById", query="from User17 where userId = :userId")
@NamedNativeQuery (name="UserDetails.ByName", 
		query="select * from USER_DETAILS16 where user_name = ?", resultClass=User17.class)
@Table (name="USER_DETAILS16")
public class User17 {
	
	private int userId;
	
	private String userName;
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
		return userName ;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
		

}
