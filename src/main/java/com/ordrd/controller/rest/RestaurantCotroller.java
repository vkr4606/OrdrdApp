package com.ordrd.controller.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ordrd.model.Restaurant;
import com.ordrd.model.filter.RestaurantFilter;
import com.ordrd.service.RestaurantService;

@RestController
public class RestaurantCotroller {

	@Autowired
	private RestaurantService restaurantService;

	@RequestMapping(value = "/restaurants/{restaurantId}", method = RequestMethod.GET)
	public ResponseEntity<Restaurant> getRestaurantById(
			@PathVariable(value = "restaurantId") String restaurantId) {
		Restaurant restaurant = restaurantService.findById(Integer.parseInt(restaurantId));
		return ResponseEntity.status(HttpStatus.OK).body(restaurant);
	}

	@RequestMapping(value = "/restaurants", method = RequestMethod.GET)
	public ResponseEntity<List<Restaurant>> getRestaurantList(
			@RequestParam(value = "nonVg", defaultValue = "0") Integer nonVegFlag,
			@RequestParam(value = "alchl", defaultValue = "0") Integer alcoholFLag,
			@RequestParam(value = "prcSrt", defaultValue = "false") Boolean priceSort,
			@RequestParam(value = "lat", required = false) Float lattitude,
			@RequestParam(value = "lng", required = false) Float longitude,
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

	@RequestMapping(value = "/restaurants", method = RequestMethod.POST)
	public ResponseEntity<?> createRestaurant(@Valid Restaurant restaurant,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(allErrors);
		}

		restaurantService.insert(restaurant);
		URI locationUri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path(String.valueOf(restaurant.getId())).build().toUri();
		return ResponseEntity.status(HttpStatus.CREATED).location(locationUri).build();
	}

	@RequestMapping(value = "/restaurants/{restaurantId}", method = RequestMethod.POST)
	public ResponseEntity<?> updateRestaurant(
			@PathVariable(value = "restaurantId") String restaurantId,
			@Valid Restaurant restaurant, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(allErrors);
		}

		restaurant.setId(Integer.parseInt(restaurantId));
		restaurantService.update(restaurant);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@RequestMapping(value = "/restaurants/{restaurantId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRestaurant(
			@PathVariable(value = "restaurantId") String restaurantId) {
		restaurantService.delete(Integer.parseInt(restaurantId));
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
