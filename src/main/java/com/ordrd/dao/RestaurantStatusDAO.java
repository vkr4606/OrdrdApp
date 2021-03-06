package com.ordrd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ordrd.model.RestaurantStatus;

@Repository
public class RestaurantStatusDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<RestaurantStatus> findAll() {
		CriteriaQuery<RestaurantStatus> criteriaQuery = entityManager.getCriteriaBuilder()
				.createQuery(RestaurantStatus.class);
		Root<RestaurantStatus> from = criteriaQuery.from(RestaurantStatus.class);
		criteriaQuery.select(from);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public RestaurantStatus findById(int restaurantId) {
		return entityManager.find(RestaurantStatus.class, restaurantId);
	}

	public void insert(RestaurantStatus restaurantStatus) {
		entityManager.persist(restaurantStatus);
	}

	public RestaurantStatus update(RestaurantStatus restaurantStatus) {
		return entityManager.merge(restaurantStatus);
	}

	public void delete(RestaurantStatus restaurantStatus) {
		entityManager.remove(restaurantStatus);
	}

}
