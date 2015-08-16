package com.ordrd.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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

	public long getTotalRecord(RestaurantFilter restaurantFilter) {
		StringBuffer query = new StringBuffer(
				"select count(p.id) from Restaurant p where p.activeFlag =:activeFlag");

		if (restaurantFilter.getActiveFlag() != 0) {
			query.append(" and p.activeFlag =:activeFlag");
		}
		if (restaurantFilter.getNonVegFlag() != 0) {
			query.append(" and p.nonVegFlag =:nonVegFlag");
		}
		if (restaurantFilter.getAlcoholFLag() != 0) {
			query.append(" and p.alcoholFlag =:alcoholFlag");
		}
		if (restaurantFilter.getLocationIds() != null
				&& !restaurantFilter.getLocationIds().isEmpty()) {
			query.append(" and p.location.id in (:ids)");
		}

		TypedQuery<Long> queryString = entityManager.createQuery(query.toString(), Long.class);

		if (restaurantFilter.getActiveFlag() != 0) {
			queryString.setParameter("activeFlag", 1);
		}
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

		return queryString.getSingleResult();

	}

	public List<Restaurant> getRestaurantList(RestaurantFilter restaurantFilter) {

		int firstRecord = (restaurantFilter.getPageNo() - 1) * restaurantFilter.getRecordsPerPage();
		StringBuffer query = new StringBuffer(
				"select p from Restaurant p where p.activeFlag =:activeFlag");

		if (restaurantFilter.getActiveFlag() != 0) {
			query.append(" and p.activeFlag =:activeFlag");
		}
		if (restaurantFilter.getNonVegFlag() != 0) {
			query.append(" and p.nonVegFlag =:nonVegFlag");
		}
		if (restaurantFilter.getAlcoholFLag() != 0) {
			query.append(" and p.alcoholFlag =:alcoholFlag");
		}
		if (restaurantFilter.getLocationIds() != null
				&& !restaurantFilter.getLocationIds().isEmpty()) {
			query.append(" and p.location.id in (:ids)");
		}

		if (restaurantFilter.isPriceSort()
				|| (restaurantFilter.getLattitude() != null && restaurantFilter.getLongitude() != null)) {
			query.append(" order by");
			if (restaurantFilter.isPriceSort()) {
				query.append(" p.priceRange.codeValue");
			}
			if (restaurantFilter.isPriceSort()
					&& (restaurantFilter.getLattitude() != null && restaurantFilter.getLongitude() != null)) {
				query.append(",");
			}
			if (restaurantFilter.getLattitude() != null && restaurantFilter.getLongitude() != null) {
				query.append("(acos((sin(p.lattitude*:pi/180)*sin(:lattitude*:pi/180)) + ")
						.append("((cos(p.lattitude*:pi/180)*cos(:lattitude*:pi/180))*(cos((p.longitude-:longitude)*:pi/180))))*180/:pi)*60*1.1515*1.609344");
			}
		}

		TypedQuery<Restaurant> queryString = entityManager.createQuery(query.toString(),
				Restaurant.class);

		if (restaurantFilter.getActiveFlag() != 0) {
			queryString.setParameter("activeFlag", 1);
		}
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

		if (restaurantFilter.getLattitude() != null && restaurantFilter.getLongitude() != null) {
			queryString.setParameter("lattitude", restaurantFilter.getLattitude());
			queryString.setParameter("longitude", restaurantFilter.getLongitude());
			queryString.setParameter("pi", new BigDecimal(Math.PI));
		}
		queryString.setFirstResult(firstRecord);
		queryString.setMaxResults(restaurantFilter.getRecordsPerPage());
		return queryString.getResultList();
	}

	public List<Restaurant> getUserSpecificRestaurant(String userName) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Restaurant> cq = cb.createQuery(Restaurant.class);
		Root<Restaurant> r = cq.from(Restaurant.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		Predicate userNamePredicate;

		if (userName != null) {
			userNamePredicate = cb.equal(r.get("userName"), userName);
			predicates.add(userNamePredicate);
		}

		cq.where(predicates.toArray(new Predicate[] {}));
		TypedQuery<Restaurant> q = entityManager.createQuery(cq);
		List<Restaurant> result = q.getResultList();

		return result;
	}
}
