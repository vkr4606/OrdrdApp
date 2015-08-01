package com.ordrd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ordrd.model.RestaurantStatus;

public class RestaurantStatusDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<RestaurantStatus> findAll() {
		CriteriaQuery<RestaurantStatus> createQuery = entityManager.getCriteriaBuilder()
				.createQuery(RestaurantStatus.class);
		Root<RestaurantStatus> from = createQuery.from(RestaurantStatus.class);
		createQuery.select(from);
		return entityManager.createQuery(createQuery).getResultList();
	}

	public RestaurantStatus findById(int restaurantId) {
		return entityManager.find(RestaurantStatus.class, restaurantId);
	}

	public void insert(RestaurantStatus restaurantCurrentStatus) {
		entityManager.persist(restaurantCurrentStatus);
	}

	public RestaurantStatus update(RestaurantStatus restaurantStatus) {
		return entityManager.merge(restaurantStatus);
	}

	public void delete(RestaurantStatus restaurantStatus) {
		entityManager.remove(restaurantStatus);
	}

}
