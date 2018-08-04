package org.lucky.hibernate.example12manyToManyMapping;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="Vehicle12")
public class Vehicle12 {
	
	private Integer id;
	private String name;
	private Collection<User12> userList = new ArrayList<User12>();
	
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
	@ManyToMany (targetEntity=User12.class, mappedBy="vehicleList")
	public Collection<User12> getUserList() {
		return userList;
	}
	public void setUserList(Collection<User12> userList) {
		this.userList = userList;
	}
	
}
