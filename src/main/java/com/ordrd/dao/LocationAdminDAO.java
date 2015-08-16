package com.ordrd.dao;

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

import com.ordrd.model.LocationAdmin;

@Repository
public class LocationAdminDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<LocationAdmin> findAll() {
		CriteriaQuery<LocationAdmin> createQuery = entityManager.getCriteriaBuilder().createQuery(
				LocationAdmin.class);
		Root<LocationAdmin> from = createQuery.from(LocationAdmin.class);
		createQuery.select(from);
		return entityManager.createQuery(createQuery).getResultList();
	}

	public LocationAdmin findById(int locationAdminId) {
		return entityManager.find(LocationAdmin.class, locationAdminId);
	}

	public void insert(LocationAdmin locationAdmin) {
		entityManager.persist(locationAdmin);
	}

	public LocationAdmin update(LocationAdmin locationAdmin) {
		return entityManager.merge(locationAdmin);
	}

	public void delete(LocationAdmin locationAdmin) {
		entityManager.remove(locationAdmin);
	}
	
	public List<LocationAdmin> findLocationsByUserName(String userName) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<LocationAdmin> cq = cb.createQuery(LocationAdmin.class);
		Root<LocationAdmin> r = cq.from(LocationAdmin.class);
		Predicate uName;
		
		if(userName != null){
			uName = cb.equal(r.get("userName"), userName);
			cq.where(uName);
			TypedQuery<LocationAdmin> q = entityManager.createQuery(cq);
			List<LocationAdmin> result = q.getResultList();
			return result;
		}
		else{
			return new ArrayList<LocationAdmin>();
		}
	}

}
