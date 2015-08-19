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

import com.ordrd.model.Location;
import com.ordrd.model.filter.LocationFilter;
import com.ordrd.service.LocationService;

@RestController
public class LocationController {

	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "/locations/{locationId}", method = RequestMethod.GET)
	public ResponseEntity<Location> getLocationById(
			@PathVariable(value = "locationId") String locationId) {
		Location location = locationService.findById(Integer.parseInt(locationId));
		return ResponseEntity.status(HttpStatus.OK).body(location);
	}

	@RequestMapping(value = "/locations", method = RequestMethod.GET)
	public ResponseEntity<List<Location>> getLocationList(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "city", required = false) String city) {

		LocationFilter locationFilter = new LocationFilter();
		locationFilter.setName(name);
		locationFilter.setCity(city);
		List<Location> locationList = locationService.getLocationList(locationFilter);
		return ResponseEntity.status(HttpStatus.OK).body(locationList);
	}

	@RequestMapping(value = "/locations", method = RequestMethod.POST)
	public ResponseEntity<?> createLocation(@Valid Location location, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(allErrors);
		}

		locationService.insert(location);
		URI locationUri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path(String.valueOf(location.getId())).build().toUri();
		return ResponseEntity.status(HttpStatus.CREATED).location(locationUri).build();
	}

	@RequestMapping(value = "/locations/{locationId}", method = RequestMethod.POST)
	public ResponseEntity<?> updateLocation(@PathVariable(value = "locationId") String locationId,
			@Valid Location location, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(allErrors);
		}

		location.setId(Integer.parseInt(locationId));
		locationService.update(location);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@RequestMapping(value = "/locations/{locationId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteLocation(@PathVariable(value = "locationId") String locationId) {
		locationService.delete(Integer.parseInt(locationId));
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
