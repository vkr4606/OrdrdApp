package com.ordrd.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ordrd.model.Restaurant;
import com.ordrd.service.RestaurantService;
import com.ordrd.variableObject.RestaurantFilter;

@RestController
public class RestaurantCotroller {

	@Autowired
	private RestaurantService restaurantService;

	@RequestMapping(value = "/restaurants", method = RequestMethod.GET)
	public ResponseEntity<List<Restaurant>> getRestaurantList(
			@RequestParam(value = "nonVg", required = false) Integer nonVegFlag,
			@RequestParam(value = "alchl", required = false) Integer alcoholFLag,
			@RequestParam(value = "prcSrt", required = false) Integer priceSort,
			@RequestParam(value = "lat", required = false) BigDecimal lattitude,
			@RequestParam(value = "long", required = false) BigDecimal longitude,
			@RequestParam(value = "lctnIds", required = false) List<Integer> locationIds) {

		List<Restaurant> restaurantList = null;
		RestaurantFilter restaurantFilter = new RestaurantFilter();
		restaurantFilter.setNonVegFlag(nonVegFlag);
		restaurantFilter.setAlcoholFLag(alcoholFLag);
		restaurantFilter.setPriceSort(priceSort);
		restaurantFilter.setLattitude(lattitude);
		restaurantFilter.setLongitude(longitude);
		restaurantFilter.setLocationIdList(locationIds);

		restaurantList = restaurantService.getRestaurantList(restaurantFilter);
		return ResponseEntity.status(HttpStatus.OK).body(restaurantList);
	}
}
