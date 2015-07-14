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
		CriteriaQuery<User> createQuery = entityManager.getCriteriaBuilder()
				.createQuery(User.class);
		Root<User> from = createQuery.from(User.class);
		createQuery.select(from);
		return entityManager.createQuery(createQuery).getResultList();
	}

	public User findById(int userId) {
		return entityManager.find(User.class, userId);
	}

	public void insert(User User) {
		entityManager.persist(User);
	}

	public void update(User User) {
		entityManager.merge(User);
	}

	public void delete(User User) {
		entityManager.remove(User);
	}

}
