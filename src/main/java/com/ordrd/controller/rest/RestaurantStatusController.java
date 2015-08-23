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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ordrd.model.RestaurantStatus;
import com.ordrd.service.RestaurantStatusService;

@RestController
public class RestaurantStatusController {

	@Autowired
	private RestaurantStatusService restaurantStatusService;

	@RequestMapping(value = "/restaurants/{restaurantId}/status", method = RequestMethod.GET)
	public ResponseEntity<RestaurantStatus> getRestaurantStatusById(
			@PathVariable(value = "restaurantId") String restaurantId) {
		RestaurantStatus restaurantStatus = restaurantStatusService.findById(Integer
				.parseInt(restaurantId));
		return ResponseEntity.status(HttpStatus.OK).body(restaurantStatus);
	}

	@RequestMapping(value = "/restaurants/status", method = RequestMethod.GET)
	public ResponseEntity<List<RestaurantStatus>> getRestaurantStatusList() {
		List<RestaurantStatus> restaurantStatusList = restaurantStatusService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(restaurantStatusList);
	}

	@RequestMapping(value = "/restaurants/status", method = RequestMethod.POST)
	public ResponseEntity<?> createRestaurantStatus(@Valid RestaurantStatus restaurantStatus,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(allErrors);
		}

		restaurantStatusService.insert(restaurantStatus);
		URI locationUri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path(String.valueOf(restaurantStatus.getId())).build().toUri();
		return ResponseEntity.status(HttpStatus.CREATED).location(locationUri).build();
	}

	@RequestMapping(value = "/restaurants/{restaurantId}/status", method = RequestMethod.POST)
	public ResponseEntity<?> updateRestaurantStatus(
			@PathVariable(value = "restaurantId") String restaurantId,
			@Valid RestaurantStatus restaurantStatus, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(allErrors);
		}

		restaurantStatus.setId(Integer.parseInt(restaurantId));
		restaurantStatusService.update(restaurantStatus);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@RequestMapping(value = "/restaurants/{restaurantId}/status", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRestaurantStatus(
			@PathVariable(value = "restaurantId") String restaurantId) {
		restaurantStatusService.delete(Integer.parseInt(restaurantId));
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
