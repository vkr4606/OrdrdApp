package com.ordrd.model;

import java.math.BigDecimal;
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
	private String contactNo;

	@Column(name = "OWNER_NAME")
	private String ownerName;

	@Column(name = "OWNER_CONTACT_NO")
	private String ownerContactNo;

	@Column(name = "MANAGER_NAME")
	private String managerName;

	@Column(name = "MANAGER_CONTACT_NO")
	private String managerContactNo;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "LOCATION_ID")
	private Location location;

	@OneToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "RESTAURANT_STATUS_ID")
	private RestaurantStatus restaurantStatus;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "LATTITUDE")
	private BigDecimal lattitude;

	@Column(name = "LONGITUDE")
	private BigDecimal longitude;

	@Column(name = "OPENING_TIME")
	@Temporal(TemporalType.TIME)
	private Date openingTime;

	@Column(name = "CLOSING_TIME")
	@Temporal(TemporalType.TIME)
	private Date closingTime;

	@Column(name = "ACTIVE_FLAG")
	private int activeFlag;

	@Column(name = "ADVANCE_BOOKING_FLAG")
	private int advanceBookingFlag;

	@Column(name = "NON_VEG_FLAG")
	private int nonVegFlag;

	@Column(name = "ALCOHOL_FLAG")
	private int alcoholFlag;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "PRICE_RANGE_ID")
	private PriceRange priceRange;

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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerContactNo() {
		return ownerContactNo;
	}

	public void setOwnerContactNo(String ownerContactNo) {
		this.ownerContactNo = ownerContactNo;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContactNo() {
		return managerContactNo;
	}

	public void setManagerContactNo(String managerContactNo) {
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

	public BigDecimal getLattitude() {
		return lattitude;
	}

	public void setLattitude(BigDecimal lattitude) {
		this.lattitude = lattitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
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

	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

	public int getAdvanceBookingFlag() {
		return advanceBookingFlag;
	}

	public void setAdvanceBookingFlag(int advanceBookingFlag) {
		this.advanceBookingFlag = advanceBookingFlag;
	}

	public int getNonVegFlag() {
		return nonVegFlag;
	}

	public void setNonVegFlag(int nonVegFlag) {
		this.nonVegFlag = nonVegFlag;
	}

	public int getAlcoholFlag() {
		return alcoholFlag;
	}

	public void setAlcoholFlag(int alcoholFlag) {
		this.alcoholFlag = alcoholFlag;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PriceRange getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(PriceRange priceRange) {
		this.priceRange = priceRange;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName()).append(" \n\t{\n\t\tid: ").append(id)
				.append("\n\t\tname: ").append(name).append("\n\t\tdescription: ")
				.append(description).append("\n\t\tcontactNo: ").append(contactNo)
				.append("\n\t\townerName: ").append(ownerName).append("\n\t\townerContactNo: ")
				.append(ownerContactNo).append("\n\t\tmanagerName: ").append(managerName)
				.append("\n\t\tmanagerContactNo: ").append(managerContactNo)
				.append("\n\t\tlocation: ").append(location).append("\n\t\trestaurantStatus: ")
				.append(restaurantStatus).append("\n\t\taddress: ").append(address)
				.append("\n\t\tlattitude: ").append(lattitude).append("\n\t\tlongitude: ")
				.append(longitude).append("\n\t\topeningTime: ").append(openingTime)
				.append("\n\t\tclosingTime: ").append(closingTime).append("\n\t\tactiveFlag: ")
				.append(activeFlag).append("\n\t\tadvanceBookingFlag: ").append(advanceBookingFlag)
				.append("\n\t\tnonVegFlag: ").append(nonVegFlag).append("\n\t\talcoholFlag: ")
				.append(alcoholFlag).append("\n\t\tuser: ").append(user)
				.append("\n\t\tpriceRange: ").append(priceRange).append("\n\t}");
		return builder.toString();
	}

}
