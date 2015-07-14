package com.ordrd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUISINE_VARIANT")
public class CuisineVariant {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "CUISINE_ID")
	private Cuisine cuisine;

	@Column(name = "NAME")
	private String name;

	@Column(name = "NONVEG_FLAG")
	private boolean nonvegFlag;

	@Column(name = "SPICE_LEVEL")
	private int spiceLevel;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "ACTIVE_FLAG")
	private boolean activeFlag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isNonvegFlag() {
		return nonvegFlag;
	}

	public void setNonvegFlag(boolean nonvegFlag) {
		this.nonvegFlag = nonvegFlag;
	}

	public int getSpiceLevel() {
		return spiceLevel;
	}

	public void setSpiceLevel(int spiceLevel) {
		this.spiceLevel = spiceLevel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

}
