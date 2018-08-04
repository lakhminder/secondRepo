package org.lucky.hibernate.example15inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="Vehicle15")
@Inheritance (strategy=InheritanceType.JOINED)
//@Inheritance (strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="Vehicle_type", discriminatorType=DiscriminatorType.STRING)
public class Vehicle15 {
	
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
