package com.ordrd.dao;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ordrd.model.Location;
import com.ordrd.model.filter.LocationFilter;

@Repository
public class LocationDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Location> findAll() {
		CriteriaQuery<Location> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(
				Location.class);
		Root<Location> from = criteriaQuery.from(Location.class);
		criteriaQuery.select(from);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public Location findById(int locationId) {
		return entityManager.find(Location.class, locationId);
	}

	public List<Location> findByFilter(LocationFilter locationFilter) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Location> q = cb.createQuery(Location.class);
		Root<Location> c = q.from(Location.class);

		List<Predicate> predicateList = new LinkedList<Predicate>();
		if (locationFilter.getName() != null) {
			predicateList.add(cb.equal(c.get("name"), locationFilter.getName()));
		}
		if (locationFilter.getCity() != null) {
			predicateList.add(cb.equal(c.get("city"), locationFilter.getCity()));
		}

		Predicate[] predicateArray = new Predicate[predicateList.size()];
		predicateList.toArray(predicateArray);
		q.select(c).where(cb.and(predicateArray));

		return entityManager.createQuery(q).getResultList();
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
