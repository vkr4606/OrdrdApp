package com.ordrd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ordrd.dao.RestaurantCurrentStatusDAO;
import com.ordrd.model.RestaurantCurrentStatus;

public class RestaurantCurrentStatusService {
	
	@Autowired
	private RestaurantCurrentStatusDAO restaurantCurrentStatusDAO;

	@Transactional
	public RestaurantCurrentStatus findById(int restaurantId) {
		RestaurantCurrentStatus restaurantCurrentStatus = restaurantCurrentStatusDAO.findById(restaurantId);
		return restaurantCurrentStatus;
	}

	@Transactional
	public List<RestaurantCurrentStatus> findAll() {
		return restaurantCurrentStatusDAO.findAll();
	}

	@Transactional
	public void insert(RestaurantCurrentStatus restaurantCurrentStatus) {
		restaurantCurrentStatusDAO.insert(restaurantCurrentStatus);
	}

	@Transactional
	public RestaurantCurrentStatus update(RestaurantCurrentStatus restaurantCurrentStatus) {
		return restaurantCurrentStatusDAO.update(restaurantCurrentStatus);
	}

	@Transactional
	public void delete(int restaurantId) {
		RestaurantCurrentStatus restaurantCurrentStatus = restaurantCurrentStatusDAO.findById(restaurantId);
		restaurantCurrentStatusDAO.delete(restaurantCurrentStatus);
	}

}
