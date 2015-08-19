package com.ordrd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ordrd.model.User;

@Repository
public class UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<User> findAll() {
		CriteriaQuery<User> criteriaQuery = entityManager.getCriteriaBuilder()
				.createQuery(User.class);
		Root<User> from = criteriaQuery.from(User.class);
		criteriaQuery.select(from);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public User findById(int userId) {
		return entityManager.find(User.class, userId);
	}

	public void insert(User user) {
		entityManager.persist(user);
	}

	public User update(User user) {
		return entityManager.merge(user);
	}

	public void delete(User user) {
		entityManager.remove(user);
	}

}
