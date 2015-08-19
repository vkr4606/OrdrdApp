package com.ordrd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ordrd.model.Customer;

@Repository
public class CustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Customer> findAll() {
		CriteriaQuery<Customer> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(
				Customer.class);
		Root<Customer> from = criteriaQuery.from(Customer.class);
		criteriaQuery.select(from);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public Customer findById(int customerId) {
		return entityManager.find(Customer.class, customerId);
	}

	public void insert(Customer customer) {
		entityManager.persist(customer);
	}

	public void update(Customer customer) {
		entityManager.merge(customer);
	}

	public void delete(Customer customer) {
		entityManager.remove(customer);
	}
}
