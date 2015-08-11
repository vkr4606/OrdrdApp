package com.ordrd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ordrd.model.PriceRange;

@Repository
public class PriceRangeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<PriceRange> findAll() {
		CriteriaQuery<PriceRange> createQuery = entityManager.getCriteriaBuilder().createQuery(
				PriceRange.class);
		Root<PriceRange> from = createQuery.from(PriceRange.class);
		createQuery.select(from);
		return entityManager.createQuery(createQuery).getResultList();
	}

	public PriceRange findById(int priceRangeId) {
		return entityManager.find(PriceRange.class, priceRangeId);
	}

	public void insert(PriceRange priceRange) {
		entityManager.persist(priceRange);
	}

	public PriceRange update(PriceRange priceRange) {
		return entityManager.merge(priceRange);
	}

	public void delete(PriceRange priceRange) {
		entityManager.remove(priceRange);
	}

}
