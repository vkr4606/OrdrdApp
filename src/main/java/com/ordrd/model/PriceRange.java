package com.ordrd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRICE_RANGE")
public class PriceRange {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	@Column(name="CODE_VALUE")
	private int codeValue;
	
	@Column(name="CODE_DESCRIPTION")
	private String codeDescription;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the codeValue
	 */
	public int getCodeValue() {
		return codeValue;
	}

	/**
	 * @param codeValue the codeValue to set
	 */
	public void setCodeValue(int codeValue) {
		this.codeValue = codeValue;
	}

	/**
	 * @return the codeDescription
	 */
	public String getCodeDescription() {
		return codeDescription;
	}

	/**
	 * @param codeDescription the codeDescription to set
	 */
	public void setCodeDescription(String codeDescription) {
		this.codeDescription = codeDescription;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName()).append(" \n{\n\tid: ").append(id)
				.append("\n\tcodeValue: ").append(codeValue)
				.append("\n\tcodeDescription: ").append(codeDescription)
				.append("\n}");
		return builder.toString();
	}

	

	

	

}
