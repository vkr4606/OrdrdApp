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
@Table(name = "RESTAURANT")
public class Restaurant {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "CONTACT_NO")
	private int contactNo;

	@Column(name = "OWNER_NAME")
	private String ownerName;

	@Column(name = "OWNER_CONTACT_NO")
	private int ownerContactNo;

	@Column(name = "MANAGER_NAME")
	private String managerName;

	@Column(name = "MANAGER_CONTACT_NO")
	private int managerContactNo;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "LOCATION_ID")
	private Location location;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "LOCATION_COORDINATES")
	private String locationCoordinates;

	@Column(name = "OPENING_TIME")
	@Temporal(TemporalType.TIME)
	private Date openingTime;

	@Column(name = "CLOSING_TIME")
	@Temporal(TemporalType.TIME)
	private Date closingTime;

	@Column(name = "PRICE_RANGE")
	private String priceRange;

	@Column(name = "RATING")
	private float rating;

	@Column(name = "RATING_LSTUPDDT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ratingLastUpdate;

	@Column(name = "ACTIVE_FLAG")
	private boolean activeFlag;

	@Column(name = "NONVEG_FLAG")
	private boolean nonvegFlag;

	@Column(name = "ALCOHOL_FLAG")
	private boolean alcoholFlag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getOwnerContactNo() {
		return ownerContactNo;
	}

	public void setOwnerContactNo(int ownerContactNo) {
		this.ownerContactNo = ownerContactNo;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getManagerContactNo() {
		return managerContactNo;
	}

	public void setManagerContactNo(int managerContactNo) {
		this.managerContactNo = managerContactNo;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocationCoordinates() {
		return locationCoordinates;
	}

	public void setLocationCoordinates(String locationCoordinates) {
		this.locationCoordinates = locationCoordinates;
	}

	public Date getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(Date openingTime) {
		this.openingTime = openingTime;
	}

	public Date getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(Date closingTime) {
		this.closingTime = closingTime;
	}

	public String getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
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

	public boolean isNonvegFlag() {
		return nonvegFlag;
	}

	public void setNonvegFlag(boolean nonvegFlag) {
		this.nonvegFlag = nonvegFlag;
	}

	public boolean isAlcoholFlag() {
		return alcoholFlag;
	}

	public void setAlcoholFlag(boolean alcoholFlag) {
		this.alcoholFlag = alcoholFlag;
	}

}
