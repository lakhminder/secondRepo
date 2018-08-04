package org.lucky.hibernate.example14oneToManyWithCascade;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




/*
 *with cascade=CascadeType.PERSIST no need to save vehicle objects explicitly. 
 */

@Entity 
@Table (name="USER_DETAILS14")
public class User14 {
	
	private int userId;
	
	private String userName;
	
	private Collection<Vehicle14> vehicleList = new ArrayList<Vehicle14>();
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
	@OneToMany (targetEntity=Vehicle14.class, mappedBy="user", cascade=CascadeType.PERSIST)
	/*@JoinTable (name="User_vehicle_xref", joinColumns={@JoinColumn(name="user_id") },
			inverseJoinColumns={@JoinColumn(name="vehicle_id")}
			)*/
	public Collection<Vehicle14> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(Collection<Vehicle14> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
	
	

}
