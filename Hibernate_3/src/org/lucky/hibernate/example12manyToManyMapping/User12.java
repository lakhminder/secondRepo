package org.lucky.hibernate.example12manyToManyMapping;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



/*
 *@ManyToMany by default creates 2 tables to store relationship from both sides
 *to avoid this(i.e to create only 1 mapping table) use mappedBy and then define mapping at one place
 */

@Entity 
@Table (name="USER_DETAILS12")
public class User12 {
	
	private int userId;
	
	private String userName;
	
	private Collection<Vehicle12> vehicleList = new ArrayList<Vehicle12>();
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
	//@OneToMany (targetEntity=Vehicle12.class, mappedBy="user")
	/*@JoinTable (name="User_vehicle_xref", joinColumns={@JoinColumn(name="user_id") },
			inverseJoinColumns={@JoinColumn(name="vehicle_id")}
			)*/
	@ManyToMany
	@JoinTable (name="User_vehicle_xref12", joinColumns={@JoinColumn(name="user_id") },
			inverseJoinColumns={@JoinColumn(name="vehicle_id")}
			)
	public Collection<Vehicle12> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(Collection<Vehicle12> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
	
	

}
