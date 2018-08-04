package org.lucky.hibernate.example15inheritance;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle15 {
	private String steeringWheel;

	public String getSteeringHandle() {
		return steeringWheel;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringWheel = steeringHandle;
	}
	
}
