package com.ordrd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATION_ADMIN")
public class LocationAdmin {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Column(name = "USER_NAME")
	private int userName;

	@Column(name = "LOCATION_ID")
	private int locationId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserName() {
		return userName;
	}

	public void setUserName(int userName) {
		this.userName = userName;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName()).append(" \n\t{\n\t\tid: ").append(id)
				.append("\n\t\tuserName: ").append(userName).append("\n\t\tlocationId: ")
				.append(locationId).append("\n\t}");
		return builder.toString();
	}

}
