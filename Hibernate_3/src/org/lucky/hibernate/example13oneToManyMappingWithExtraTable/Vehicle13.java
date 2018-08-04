package org.lucky.hibernate.example13oneToManyMappingWithExtraTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="Vehicle13")
public class Vehicle13 {
	
	private Integer id;
	private String name;
	private User13 user;
	
	@Id
	@Column (name="Vehicle_ID")
	@SequenceGenerator (name="generator2",sequenceName="vehicle_sequence")
	@GeneratedValue (generator="generator2")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column (name="Vehicle_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	@JoinTable (name="User_vehicle_xref", joinColumns={@JoinColumn(name="vehicle_id") },
			inverseJoinColumns={@JoinColumn(name="user_id")}
			)
	//@JoinColumn (name="userTable_user_ID")
	public User13 getUser() {
		return user;
	}
	public void setUser(User13 user) {
		this.user = user;
	}
}
