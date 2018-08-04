package org.lucky.hibernate.example10oneToOneMapping;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/*
 *@OneToOne is used to define relationship
 *create @OneToOne in Vehicle for user if you want to refer the user from vehicle object
 *an explicit session.save(vehicle) is required as there is no cascade 
 */

@Entity 
@Table (name="USER_DETAILS10")
public class User10 {
	@Id
	@Column (name="USER_ID")
	//@GenericGenerator(name = "generator1", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "lucky_sequence"))
	@SequenceGenerator (name="generator2",sequenceName="lucky_sequence")
	@GeneratedValue (generator="generator2")
	private int userId;
	@Column (name="USER_NAME")
	private String userName;
	@OneToOne
	@JoinColumn (name="vehicle_id")
	private Vehicle vehicle;
	
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
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	

}
