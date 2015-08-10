package com.ordrd.variableObject;


import java.math.BigDecimal;
import java.util.List;

import com.ordrd.model.Location;

public class RestaurantFilter {
	private Integer nonVegFlag;
	private Integer alcoholFLag;
	private Integer priceSort;
	private List<Integer> locationIdList;
	private BigDecimal lattitude;
	private BigDecimal longitude;
	
	
	public Integer getNonVegFlag() {
		return nonVegFlag;
	}
	public void setNonVegFlag(Integer nonVegFlag) {
		this.nonVegFlag = nonVegFlag;
	}
	/**
	 * @return the alcoholFLag
	 */
	public Integer getAlcoholFLag() {
		return alcoholFLag;
	}
	/**
	 * @param alcoholFLag the alcoholFLag to set
	 */
	public void setAlcoholFLag(Integer alcoholFLag) {
		this.alcoholFLag = alcoholFLag;
	}
	public Integer getPriceSort() {
		return priceSort;
	}
	public void setPriceSort(Integer priceSort) {
		this.priceSort = priceSort;
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
	public List<Integer> getLocationIdList() {
		return locationIdList;
	}
	public void setLocationIdList(List<Integer> locationIdList) {
		this.locationIdList = locationIdList;
	}
	

}
