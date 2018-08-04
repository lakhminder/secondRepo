package org.lucky.hibernate.example10oneToOneMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="Vehicle")
public class Vehicle {
	
	private Integer id;
	private String name;
	
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
}
