package com.ordrd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRICE_RANGE")
public class PriceRange {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Column(name = "CODE_VALUE")
	private int codeValue;

	@Column(name = "CODE_DESCRIPTION")
	private String codeDescription;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(int codeValue) {
		this.codeValue = codeValue;
	}

	public String getCodeDescription() {
		return codeDescription;
	}

	public void setCodeDescription(String codeDescription) {
		this.codeDescription = codeDescription;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PriceRange {\n\tid=").append(id).append("\n\tcodeValue=").append(codeValue)
				.append("\n\tcodeDescription=").append(codeDescription).append("\n}");
		return builder.toString();
	}

}
