package com.ordrd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

	public Integer getTotalRecord(RestaurantFilter restaurantFilter) {
		// CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		// CriteriaQuery<Long> query = cb.createQuery(Long.class);
		// Root<Restaurant> root = query.from(Restaurant.class);
		// query.select(cb.count(root));
		// Long count = entityManager.createQuery(query).getSingleResult();
		// return count.intValue();
		String query = "select count(p.id) from Restaurant p where p.activeFlag =:activeFlag";

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

		Query queryString = entityManager.createQuery(query);
		queryString.setParameter("lattitude", restaurantFilter.getLattitude());
		queryString.setParameter("longitude", restaurantFilter.getLongitude());
		queryString.setParameter("pi", new Float(Math.PI));
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

		return (Integer) queryString.getSingleResult();

	}

	public List<Restaurant> getRestaurantList(RestaurantFilter restaurantFilter) {

		int firstRecord = (restaurantFilter.getPageNo() - 1) * restaurantFilter.getRecordsPerPage();
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

		if(restaurantFilter.isPriceSort() || (restaurantFilter.getLattitude() != null && restaurantFilter.getLongitude() != null)){
			query = query + " order by";
			if (restaurantFilter.isPriceSort()) {
				query = query + " p.priceRange.codeValue";
			}
			if(restaurantFilter.isPriceSort() && (restaurantFilter.getLattitude() != null && restaurantFilter.getLongitude() != null)){
				query = query + ",";
			}
			if(restaurantFilter.getLattitude() != null && restaurantFilter.getLongitude() != null){
				query = query
						+ "(acos((sin(p.lattitude*:pi/180)*sin(:lattitude*:pi/180))+"
						+ "((cos(p.lattitude*:pi/180)*cos(:lattitude*:pi/180))*(cos((p.longitude-:longitude)*:pi/180))))*180/:pi)*60*1.1515*1.609344";
			}	
		}
		
		TypedQuery<Restaurant> queryString = entityManager.createQuery(query, Restaurant.class);
		
		if(restaurantFilter.getLattitude() != null && restaurantFilter.getLongitude() != null){
			queryString.setParameter("lattitude", restaurantFilter.getLattitude());
			queryString.setParameter("longitude", restaurantFilter.getLongitude());
			queryString.setParameter("pi", new Float(Math.PI));
		}
		
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
		queryString.setFirstResult(firstRecord);
		queryString.setMaxResults(restaurantFilter.getRecordsPerPage());
		return queryString.getResultList();
	}
}
