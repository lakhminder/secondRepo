package org.lucky.hibernate.example11oneToManyMapping;


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
 *@OneToMany is used in User11 to relate to Vehicle
 *@ManytoOne is used in Vehicle to relate to User
 *@JoinColumn is used to specify the name of column
 */

@Entity 
@Table (name="USER_DETAILS11")
public class User11 {
	
	private int userId;
	
	private String userName;
	
	private Collection<Vehicle1> vehicleList = new ArrayList<Vehicle1>();
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
	@OneToMany (targetEntity=Vehicle1.class, mappedBy="user")
	/*@JoinTable (name="User_vehicle_xref", joinColumns={@JoinColumn(name="user_id") },
			inverseJoinColumns={@JoinColumn(name="vehicle_id")}
			)*/
	public Collection<Vehicle1> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(Collection<Vehicle1> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
	
	

}
