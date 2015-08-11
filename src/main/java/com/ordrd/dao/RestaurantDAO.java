package com.ordrd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ordrd.model.Restaurant;
import com.ordrd.model.filter.RestaurantFilter;

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

	public List<Restaurant> getRestaurantList(RestaurantFilter restaurantFilter) {

		String query = "select p from Restaurant p where p.activeFlag =:activeFlag";

		if (restaurantFilter.getNonVegFlag() != 0) {
			query = query + " and p.nonVegFlag =:nonVegFlag";
		}
		if (restaurantFilter.getAlcoholFLag() != 0) {
			query = query + " and p.alcoholFlag =:alcoholFlag";
		}
		if (restaurantFilter.getLocationIds() != null
				&& !restaurantFilter.getLocationIds().isEmpty()) {
			query = query + " and p.location.id in (:ids)";
		}
		if (restaurantFilter.isPriceSort()) {
			query = query + " order by p.priceRange.codeValue asc";
		}

		TypedQuery<Restaurant> queryString = entityManager.createQuery(query, Restaurant.class);

		queryString.setParameter("activeFlag", 1);
		if (restaurantFilter.getNonVegFlag() != 0) {
			queryString.setParameter("nonVegFlag", restaurantFilter.getNonVegFlag());
		}
		if (restaurantFilter.getAlcoholFLag() != 0) {
			queryString.setParameter("alcoholFlag", restaurantFilter.getAlcoholFLag());
		}
		if (restaurantFilter.getLocationIds() != null
				&& !restaurantFilter.getLocationIds().isEmpty()) {
			queryString.setParameter("ids", restaurantFilter.getLocationIds());
		}

		return queryString.getResultList();
	}
}
