package com.ordrd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ordrd.model.Location;

public class LocationDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Location> findAll() {
		CriteriaQuery<Location> createQuery = entityManager.getCriteriaBuilder()
				.createQuery(Location.class);
		Root<Location> from = createQuery.from(Location.class);
		createQuery.select(from);
		return entityManager.createQuery(createQuery).getResultList();
	}

	public Location findById(int locationId) {
		return entityManager.find(Location.class, locationId);
	}

	public void insert(Location location) {
		entityManager.persist(location);
	}

	public Location update(Location location) {
		return entityManager.merge(location);
	}

	public void delete(Location location) {
		entityManager.remove(location);
	}

}
