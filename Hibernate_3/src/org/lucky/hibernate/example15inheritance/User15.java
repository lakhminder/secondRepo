package org.lucky.hibernate.example15inheritance;


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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




/*
 *1) By defalut if in child class you make those as @Entity , then by default single table strategy is picked
 *however to have the discriminator column more meaningful(as per your own need), use @DiscriminatorColumn in base class and
 *@DiscriminatorValue("Bike") in child class else it will have the class name as discriminator column value by default in DB
 *
 *2) use @Inheritance (strategy=InheritanceType.TABLE_PER_CLASS) and remove discriminator stuff from child and parent classes
 * to have seperate table for each entity.
 * 
 *3) use @Inheritance (strategy=InheritanceType.JOINED) for having child table with child columns and parent id as foregn key
 */

@Entity 
@Table (name="USER_DETAILS15")
public class User15 {
	
	private int userId;
	
	private String userName;
	
	private Collection<Vehicle15> vehicleList = new ArrayList<Vehicle15>();
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
	@OneToMany (cascade=CascadeType.ALL)
	public Collection<Vehicle15> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(Collection<Vehicle15> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
	
	

}
