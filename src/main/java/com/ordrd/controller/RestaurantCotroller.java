package com.ordrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ordrd.model.Restaurant;
import com.ordrd.model.filter.RestaurantFilter;
import com.ordrd.service.RestaurantService;

@RestController
public class RestaurantCotroller {

	@Autowired
	private RestaurantService restaurantService;

	@RequestMapping(value = "/restaurants", method = RequestMethod.GET)
	public ResponseEntity<List<Restaurant>> getRestaurantList(
			@RequestParam(value = "nonVg", defaultValue = "0") Integer nonVegFlag,
			@RequestParam(value = "alchl", defaultValue = "0") Integer alcoholFLag,
			@RequestParam(value = "prcSrt", defaultValue = "false") Boolean priceSort,
			@RequestParam(value = "lat", required = false) Float lattitude,
			@RequestParam(value = "long", required = false) Float longitude,
			@RequestParam(value = "lctnIds", required = false) List<Integer> locationIds) {

		RestaurantFilter restaurantFilter = new RestaurantFilter();
		restaurantFilter.setNonVegFlag(nonVegFlag);
		restaurantFilter.setAlcoholFLag(alcoholFLag);
		restaurantFilter.setPriceSort(priceSort);
		restaurantFilter.setLattitude(lattitude);
		restaurantFilter.setLongitude(longitude);
		restaurantFilter.setLocationIds(locationIds);

		List<Restaurant> restaurantList = restaurantService.getRestaurantList(restaurantFilter);
		return ResponseEntity.status(HttpStatus.OK).body(restaurantList);
	}
}
