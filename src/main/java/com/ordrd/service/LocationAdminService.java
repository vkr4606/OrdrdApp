package com.ordrd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordrd.dao.LocationAdminDAO;
import com.ordrd.model.LocationAdmin;

@Service
public class LocationAdminService {

	@Autowired
	private LocationAdminDAO locationAdminDAO;

	@Transactional
	public LocationAdmin findById(int locationAdminId) {
		return locationAdminDAO.findById(locationAdminId);
	}

	@Transactional
	public List<LocationAdmin> findAll() {
		return locationAdminDAO.findAll();
	}

	@Transactional
	public void insert(LocationAdmin locationAdmin) {
		locationAdminDAO.insert(locationAdmin);
	}

	@Transactional
	public LocationAdmin update(LocationAdmin locationAdmin) {
		return locationAdminDAO.update(locationAdmin);
	}

	@Transactional
	public void delete(int locationAdminId) {
		LocationAdmin locationAdmin = locationAdminDAO.findById(locationAdminId);
		locationAdminDAO.delete(locationAdmin);
	}

	@Transactional
	public List<LocationAdmin> findLocationsByUserName(String userName) {
		return locationAdminDAO.findLocationsByUserName(userName);
	}

}
