package com.ordrd.model.filter;

public class LocationFilter {

	private String name;

	private String city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LocationFilter {\n\tname=").append(name).append("\n\tcity=").append(city)
				.append("\n}");
		return builder.toString();
	}

}
