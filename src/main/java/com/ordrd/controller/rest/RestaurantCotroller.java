package com.ordrd.controller.rest;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ordrd.model.LocationAdmin;
import com.ordrd.model.Restaurant;
import com.ordrd.model.WebObject;
import com.ordrd.model.filter.RestaurantFilter;
import com.ordrd.service.LocationAdminService;
import com.ordrd.service.RestaurantService;

@RestController
public class RestaurantCotroller {

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private LocationAdminService locationAdminService;

	@RequestMapping(value = "/restaurants/{restaurantId}", method = RequestMethod.GET)
	public ResponseEntity<Restaurant> getRestaurantById(
			@PathVariable(value = "restaurantId") String restaurantId) {
		Restaurant restaurant = restaurantService.findById(Integer.parseInt(restaurantId));
		return ResponseEntity.status(HttpStatus.OK).body(restaurant);
	}

	@RequestMapping(value = "/restaurants", method = RequestMethod.GET)
	public ResponseEntity<WebObject<Restaurant>> getRestaurantList(
			@RequestParam(value = "nonVg", defaultValue = "0") Integer nonVegFlag,
			@RequestParam(value = "alchl", defaultValue = "0") Integer alcoholFLag,
			@RequestParam(value = "prcSrt", defaultValue = "false") Boolean priceSort,
			@RequestParam(value = "lat", required = false) BigDecimal lattitude,
			@RequestParam(value = "lng", required = false) BigDecimal longitude,
			@RequestParam(value = "lcnIds", required = false) List<Integer> locationIds,
			@RequestParam(value = "pNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pSize", defaultValue = "5") Integer pageSize) {

		RestaurantFilter restaurantFilter = new RestaurantFilter();
		WebObject<Restaurant> returnObject = new WebObject<Restaurant>();
		List<Restaurant> restaurantList;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();

		Iterator<? extends GrantedAuthority> authorities = authentication.getAuthorities()
				.iterator();
		if (authorities.hasNext()) {
			restaurantFilter.setUserRole(authorities.next().getAuthority());
		}

		if (restaurantFilter.getUserRole().compareTo("ROLE_OWNER") == 0) {
			restaurantList = restaurantService.getUserSpecificRestaurant(userName);

			returnObject.setTotalCount(1);
			returnObject.setModelList(restaurantList);
		}
		if (restaurantFilter.getUserRole().compareTo("ROLE_ADMIN") == 0) {
			restaurantFilter.setNonVegFlag(nonVegFlag);
			restaurantFilter.setAlcoholFLag(alcoholFLag);
			restaurantFilter.setPriceSort(priceSort);
			restaurantFilter.setLocationIds(locationIds);
			restaurantFilter.setPageNo(pageNo);
			restaurantFilter.setRecordsPerPage(pageSize);

			long totalRecord = restaurantService.getTotalRecord(restaurantFilter);
			restaurantList = restaurantService.getRestaurantList(restaurantFilter);

			returnObject.setTotalCount(totalRecord);
			returnObject.setModelList(restaurantList);
		}
		if (restaurantFilter.getUserRole().compareTo("ROLE_USER") == 0) {
			restaurantFilter.setNonVegFlag(nonVegFlag);
			restaurantFilter.setAlcoholFLag(alcoholFLag);
			restaurantFilter.setPriceSort(priceSort);
			restaurantFilter.setLattitude(lattitude);
			restaurantFilter.setLongitude(longitude);
			restaurantFilter.setLocationIds(locationIds);
			restaurantFilter.setActiveFlag(1);
			restaurantFilter.setPageNo(pageNo);
			restaurantFilter.setRecordsPerPage(pageSize);

			long totalRecord = restaurantService.getTotalRecord(restaurantFilter);
			restaurantList = restaurantService.getRestaurantList(restaurantFilter);

			returnObject.setTotalCount(totalRecord);
			returnObject.setModelList(restaurantList);
		}
		if (restaurantFilter.getUserRole().compareTo("ROLE_LCTN_ADMIN") == 0) {
			restaurantFilter.setActiveFlag(1);
			restaurantFilter.setPageNo(pageNo);
			restaurantFilter.setRecordsPerPage(pageSize);

			List<Integer> locationIdsTemp = new ArrayList<Integer>();
			List<LocationAdmin> locationAdminList = locationAdminService
					.findLocationsByUserName(userName);

			for (LocationAdmin tempLocationAdmin : locationAdminList) {
				locationIdsTemp.add(tempLocationAdmin.getLocationId());
			}
			
			if(locationIdsTemp != null && locationIdsTemp.size() > 0) {
				restaurantFilter.setLocationIds(locationIdsTemp);
				long totalRecord = restaurantService.getTotalRecord(restaurantFilter);
				restaurantList = restaurantService.getRestaurantList(restaurantFilter);

				returnObject.setTotalCount(totalRecord);
				returnObject.setModelList(restaurantList);
			} else {
				//Return Empty Restaurant List
				returnObject.setTotalCount(0);
			}
					}

		return ResponseEntity.status(HttpStatus.OK).body(returnObject);
	}

	@RequestMapping(value = "/restaurants", method = RequestMethod.POST)
	public ResponseEntity<?> createRestaurant(@Valid Restaurant restaurant,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(allErrors);
		}
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

	@SuppressWarnings("unused")
	private float calculateDistance(Float lat1, Float lng1, Float lat2, Float lng2) {
		double theta = lng1 - lng2;
		double theta_rad = (theta * Math.PI / 180.0);

		double lat1_rad = (lat1 * Math.PI / 180.0);
		double lat2_rad = (lat2 * Math.PI / 180.0);

		double distance = Math.sin(lat1_rad) * Math.sin(lat2_rad) + Math.cos(lat1_rad)
				* Math.cos(lat2_rad) * Math.cos(theta_rad);

		distance = Math.acos(distance);
		distance = (distance * 180.0 / Math.PI);
		distance = distance * 60 * 1.1515 * 1.609344;
		return new Float(distance);
	}

}
