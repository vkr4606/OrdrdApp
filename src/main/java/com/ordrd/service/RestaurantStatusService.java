package com.ordrd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordrd.dao.RestaurantStatusDAO;
import com.ordrd.model.RestaurantStatus;

@Service
public class RestaurantStatusService {

	@Autowired
	private RestaurantStatusDAO restaurantStatusDAO;

	@Transactional
	public RestaurantStatus findById(int restaurantId) {
		RestaurantStatus restaurantStatus = restaurantStatusDAO.findById(restaurantId);
		return restaurantStatus;
	}

	@Transactional
	public List<RestaurantStatus> findAll() {
		return restaurantStatusDAO.findAll();
	}

	@Transactional
	public void insert(RestaurantStatus restaurantStatus) {
		restaurantStatusDAO.insert(restaurantStatus);
	}

	@Transactional
	public RestaurantStatus update(RestaurantStatus restaurantStatus) {
		return restaurantStatusDAO.update(restaurantStatus);
	}

	@Transactional
	public void delete(int restaurantId) {
		RestaurantStatus restaurantStatus = restaurantStatusDAO.findById(restaurantId);
		restaurantStatusDAO.delete(restaurantStatus);
	}

}
