package com.ordrd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CUISINE")
public class Cuisine {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "RESTAURANT_ID")
	private Restaurant restaurant;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "MENU_ID")
	private Menu menu;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "TYPE_TAG")
	private String typeTag;

	@Column(name = "RATING_FLAG")
	private boolean ratingFlag;

	@Column(name = "RATING")
	private float rating;

	@Column(name = "RATING_LSTUPDDT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ratingLastUpdate;

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

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeTag() {
		return typeTag;
	}

	public void setTypeTag(String typeTag) {
		this.typeTag = typeTag;
	}

	public boolean isRatingFlag() {
		return ratingFlag;
	}

	public void setRatingFlag(boolean ratingFlag) {
		this.ratingFlag = ratingFlag;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Date getRatingLastUpdate() {
		return ratingLastUpdate;
	}

	public void setRatingLastUpdate(Date ratingLastUpdate) {
		this.ratingLastUpdate = ratingLastUpdate;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

}
