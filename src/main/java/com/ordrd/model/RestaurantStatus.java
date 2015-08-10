package com.ordrd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESTAURANT_STATUS")
public class RestaurantStatus {

	@Id
	@Column(name = "ID")
	private int id;

	/**
	 * Used to depict % Occupancy of a particular Restaurant Percent Range of 10
	 * (0-100)
	 */
	@Column(name = "OCCUPANCY")
	private int occupancy;

	/**
	 * Wait Time is defined in Range of 10 minutes
	 */
	@Column(name = "WAIT_TIME_2")
	private int waitTime2;

	@Column(name = "WAIT_TIME_GROUP")
	private int waitTimeGroup;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}

	public int getWaitTime2() {
		return waitTime2;
	}

	public void setWaitTime2(int waitTime2) {
		this.waitTime2 = waitTime2;
	}

	public int getWaitTimeGroup() {
		return waitTimeGroup;
	}

	public void setWaitTimeGroup(int waitTimeGroup) {
		this.waitTimeGroup = waitTimeGroup;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestaurantStatus {\n\tid=").append(id).append("\n\toccupancy=")
				.append(occupancy).append("\n\twaitTime2=").append(waitTime2)
				.append("\n\twaitTimeGroup=").append(waitTimeGroup).append("\n}");
		return builder.toString();
	}

}
