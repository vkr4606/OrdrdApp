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

	public PriceRange getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(PriceRange priceRange) {
		this.priceRange = priceRange;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Restaurant {\n\tid=").append(id).append("\n\tname=").append(name)
				.append("\n\tdescription=").append(description).append("\n\tcontactNo=")
				.append(contactNo).append("\n\townerName=").append(ownerName)
				.append("\n\townerContactNo=").append(ownerContactNo).append("\n\tmanagerName=")
				.append(managerName).append("\n\tmanagerContactNo=").append(managerContactNo)
				.append("\n\tlocation=").append(location).append("\n\trestaurantStatus=")
				.append(restaurantStatus).append("\n\taddress=").append(address)
				.append("\n\tlattitude=").append(lattitude).append("\n\tlongitude=")
				.append(longitude).append("\n\topeningTime=").append(openingTime)
				.append("\n\tclosingTime=").append(closingTime).append("\n\tactiveFlag=")
				.append(activeFlag).append("\n\tadvanceBookingFlag=").append(advanceBookingFlag)
				.append("\n\tnonVegFlag=").append(nonVegFlag).append("\n\talcoholFlag=")
				.append(alcoholFlag).append("\n\tpriceRange=").append(priceRange).append("\n}");
		return builder.toString();
	}

}
