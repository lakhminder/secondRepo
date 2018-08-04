package org.lucky.hibernate.example13oneToManyMappingWithExtraTable;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.lucky.hibernate.example10oneToOneMapping.Vehicle;


/*
 *@OneToMany (targetEntity=Vehicle13.class, mappedBy="user")is used to specify that refer mapping from Vehicle13.java
 *@JoinTable is used to specify extra table to store the relationship
 */

@Entity 
@Table (name="USER_DETAILS13")
public class User13 {
	
	private int userId;
	
	private String userName;
	
	private Collection<Vehicle13> vehicleList = new ArrayList<Vehicle13>();
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
	@OneToMany (targetEntity=Vehicle13.class, mappedBy="user")
	/*@JoinTable (name="User_vehicle_xref", joinColumns={@JoinColumn(name="user_id") },
			inverseJoinColumns={@JoinColumn(name="vehicle_id")}
			)*/
	public Collection<Vehicle13> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(Collection<Vehicle13> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
	
	

}
