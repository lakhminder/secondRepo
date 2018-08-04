package org.lucky.hibernate.example8collectionId;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

/*
 *@ElementCollection is used to specify that collection is stored as 2nd table referring to primary table with foreign key 
 *however the 2nd table(Parent table) won't be be having a primary key/indexed column.
 *To have indexed column or primary key for 2nd Table(Parent Table) we need to use arraylist which is indexed and @CollectionId
 *Also to specify Column name for 2nd Table(Parent Table) use @JoinTable
 */

@Entity 
@Table (name="USER_DETAILS8")
public class User8 {
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
	@ElementCollection
	@JoinTable (name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator (name = "hiloGenrator", strategy = "hilo")
	@CollectionId(columns = { @Column(name="USER_ADDRESS_ID") }, generator = "hiloGenrator", type = @Type (type="long"))
	private Collection<Address> listOfAddresses = new ArrayList();
	
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
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

}
