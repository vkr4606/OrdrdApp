package com.ordrd.model.filter;

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
	private Float lattitude;
	private Float longitude;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestaurantFilter {\n\tnonVegFlag=").append(nonVegFlag)
				.append("\n\talcoholFLag=").append(alcoholFLag).append("\n\tpriceSort=")
				.append(priceSort).append("\n\tlocationIds=").append(locationIds)
				.append("\n\tlattitude=").append(lattitude).append("\n\tlongitude=")
				.append(longitude).append("\n}");
		return builder.toString();
	}

}
