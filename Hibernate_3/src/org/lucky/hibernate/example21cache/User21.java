package org.lucky.hibernate.example21cache;



import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/*
 * 
 */

@Entity 
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table (name="USER_DETAILS16")
public class User21 {
	
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
	@Override
	public String toString() {
		return getUserName();
	}
		


}
