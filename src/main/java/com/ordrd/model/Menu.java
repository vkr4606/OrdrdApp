package com.ordrd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MENU")
public class Menu {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "RESTAURANT_ID")
	private Restaurant restaurant;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "ACTIVE_FLAG")
	private boolean activeFlag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
}
