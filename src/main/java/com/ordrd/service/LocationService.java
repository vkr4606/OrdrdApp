package com.ordrd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordrd.dao.LocationDAO;
import com.ordrd.model.Location;

@Service
public class LocationService {

	@Autowired
	private LocationDAO locationDAO;

	@Transactional
	public Location findById(int locationId) {
		Location location = locationDAO.findById(locationId);
		return location;
	}

	@Transactional
	public List<Location> findAll() {
		return locationDAO.findAll();
	}

	@Transactional
	public void insert(Location location) {
		locationDAO.insert(location);
	}

	@Transactional
	public Location update(Location location) {
		return locationDAO.update(location);
	}

	@Transactional
	public void delete(int locationId) {
		Location location = locationDAO.findById(locationId);
		locationDAO.delete(location);
	}

}
