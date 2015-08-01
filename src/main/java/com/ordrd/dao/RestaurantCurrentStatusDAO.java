package com.ordrd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ordrd.model.RestaurantCurrentStatus;

public class RestaurantCurrentStatusDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<RestaurantCurrentStatus> findAll() {
		CriteriaQuery<RestaurantCurrentStatus> createQuery = entityManager.getCriteriaBuilder()
				.createQuery(RestaurantCurrentStatus.class);
		Root<RestaurantCurrentStatus> from = createQuery.from(RestaurantCurrentStatus.class);
		createQuery.select(from);
		return entityManager.createQuery(createQuery).getResultList();
	}

	public RestaurantCurrentStatus findById(int restaurantId) {
		return entityManager.find(RestaurantCurrentStatus.class, restaurantId);
	}

	public void insert(RestaurantCurrentStatus restaurantCurrentStatus) {
		entityManager.persist(restaurantCurrentStatus);
	}

	public RestaurantCurrentStatus update(RestaurantCurrentStatus restaurantCurrentStatus) {
		return entityManager.merge(restaurantCurrentStatus);
	}

	public void delete(RestaurantCurrentStatus restaurantCurrentStatus) {
		entityManager.remove(restaurantCurrentStatus);
	}

}
