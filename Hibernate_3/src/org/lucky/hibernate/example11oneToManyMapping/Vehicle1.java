package org.lucky.hibernate.example11oneToManyMapping;

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
@Table (name="Vehicle1")
public class Vehicle1 {
	
	private Integer id;
	private String name;
	private User11 user;
	
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
	@JoinColumn (name="userTable_user_ID")
	public User11 getUser() {
		return user;
	}
	public void setUser(User11 user) {
		this.user = user;
	}
}
