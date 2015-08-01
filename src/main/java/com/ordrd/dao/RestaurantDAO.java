package com.ordrd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ordrd.model.Restaurant;

@Repository
public class RestaurantDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Restaurant> findAll() {
		CriteriaQuery<Restaurant> createQuery = entityManager.getCriteriaBuilder().createQuery(
				Restaurant.class);
		Root<Restaurant> from = createQuery.from(Restaurant.class);
		createQuery.select(from);
		return entityManager.createQuery(createQuery).getResultList();
	}

	public Restaurant findById(int restaurantId) {
		return entityManager.find(Restaurant.class, restaurantId);
	}

	public void insert(Restaurant restaurant) {
		entityManager.persist(restaurant);
	}

	public Restaurant update(Restaurant restaurant) {
		return entityManager.merge(restaurant);
	}

	public void delete(Restaurant restaurant) {
		entityManager.remove(restaurant);
	}

}
