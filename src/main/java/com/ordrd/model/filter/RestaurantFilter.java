package com.ordrd.model.filter;

import java.math.BigDecimal;
import java.util.List;

public class RestaurantFilter {

	/**
	 * 1 = Serves only veg, 2 = Serves non-veg
	 */
	private int nonVegFlag;

	/**
	 * 1 = Doesn't serve alcohol, 2 = Serves alcohol
	 */
	private int alcoholFLag;

	private boolean priceSort;

	private List<Integer> locationIds;

	private BigDecimal lattitude;

	private BigDecimal longitude;

	private int pageNo;

	private int recordsPerPage;

	private String userName;

	private String userRole;

	private int activeFlag;

	public int getNonVegFlag() {
		return nonVegFlag;
	}

	public void setNonVegFlag(int nonVegFlag) {
		this.nonVegFlag = nonVegFlag;
	}

	public int getAlcoholFLag() {
		return alcoholFLag;
	}

	public void setAlcoholFLag(int alcoholFLag) {
		this.alcoholFLag = alcoholFLag;
	}

	public boolean isPriceSort() {
		return priceSort;
	}

	public void setPriceSort(boolean priceSort) {
		this.priceSort = priceSort;
	}

	public List<Integer> getLocationIds() {
		return locationIds;
	}

	public void setLocationIds(List<Integer> locationIds) {
		this.locationIds = locationIds;
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

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestaurantFilter {\n\tnonVegFlag=").append(nonVegFlag)
				.append("\n\talcoholFLag=").append(alcoholFLag).append("\n\tpriceSort=")
				.append(priceSort).append("\n\tlocationIds=").append(locationIds)
				.append("\n\tlattitude=").append(lattitude).append("\n\tlongitude=")
				.append(longitude).append("\n\tpageNo=").append(pageNo)
				.append("\n\trecordsPerPage=").append(recordsPerPage).append("\n\tuserName=")
				.append(userName).append("\n\tuserRole=").append(userRole)
				.append("\n\tactiveFlag=").append(activeFlag).append("\n}");
		return builder.toString();
	}

}
