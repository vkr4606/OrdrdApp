package com.ordrd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ordrd.model.UserQuery;

public class UserQueryDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<UserQuery> findAll() {
		CriteriaQuery<UserQuery> createQuery = entityManager.getCriteriaBuilder()
				.createQuery(UserQuery.class);
		Root<UserQuery> from = createQuery.from(UserQuery.class);
		createQuery.select(from);
		return entityManager.createQuery(createQuery).getResultList();
	}

	public UserQuery findById(int userQueryId) {
		return entityManager.find(UserQuery.class, userQueryId);
	}

	public void insert(UserQuery userQuery) {
		entityManager.persist(userQuery);
	}

	public UserQuery update(UserQuery userQuery) {
		return entityManager.merge(userQuery);
	}

	public void delete(UserQuery userQuery) {
		entityManager.remove(userQuery);
	}

}
