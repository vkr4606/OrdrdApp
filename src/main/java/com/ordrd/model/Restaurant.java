package com.ordrd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

	@OneToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "RESTAURANT_STATUS_ID")
	private RestaurantStatus restaurantStatus;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "LATTITUDE")
	private Float lattitude;

	@Column(name = "LONGITUDE")
	private Float longitude;

	@Column(name = "OPENING_TIME")
	@Temporal(TemporalType.TIME)
	private Date openingTime;

	@Column(name = "CLOSING_TIME")
	@Temporal(TemporalType.TIME)
	private Date closingTime;

	@Column(name = "ACTIVE_FLAG")
	private boolean activeFlag;

	@Column(name = "ADVANCE_BOOKING_FLAG")
	private boolean advanceBookingFlag;

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

	public RestaurantStatus getRestaurantStatus() {
		return restaurantStatus;
	}

	public void setRestaurantStatus(RestaurantStatus restaurantStatus) {
		this.restaurantStatus = restaurantStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getLattitude() {
		return lattitude;
	}

	public void setLattitude(Float lattitude) {
		this.lattitude = lattitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
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

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public boolean isAdvanceBookingFlag() {
		return advanceBookingFlag;
	}

	public void setAdvanceBookingFlag(boolean advanceBookingFlag) {
		this.advanceBookingFlag = advanceBookingFlag;
	}

}
