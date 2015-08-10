package com.ordrd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordrd.dao.RestaurantDAO;
import com.ordrd.model.Restaurant;
import com.ordrd.model.filter.RestaurantFilter;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantDAO restaurantDAO;

	@Transactional
	public Restaurant findById(int restaurantId) {
		return restaurantDAO.findById(restaurantId);
	}

	@Transactional
	public List<Restaurant> findAll() {
		return restaurantDAO.findAll();
	}

	@Transactional
	public void insert(Restaurant restaurant) {
		restaurantDAO.insert(restaurant);
	}

	@Transactional
	public Restaurant update(Restaurant restaurant) {
		return restaurantDAO.update(restaurant);
	}

	@Transactional
	public void delete(int restaurantId) {
		Restaurant restaurant = restaurantDAO.findById(restaurantId);
		restaurantDAO.delete(restaurant);
	}

	@Transactional
	public List<Restaurant> getRestaurantList(RestaurantFilter restaurantFilter) {
		return restaurantDAO.getRestaurantList(restaurantFilter);
	}

}
