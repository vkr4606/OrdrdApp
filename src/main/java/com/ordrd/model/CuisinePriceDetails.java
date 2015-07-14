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
@Table(name = "CUISINE_PRICE_DETAILS")
public class CuisinePriceDetails {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "CUISINE_VARIANT_ID")
	private CuisineVariant cuisineVariant;

	@Column(name = "CUISINE_QUANTITY")
	private String cuisineQuantity;
	
	@Column(name="PRICE")
	private float price;

}
