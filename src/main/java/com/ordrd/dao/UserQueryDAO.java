package com.ordrd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ordrd.model.UserQuery;

@Repository
public class UserQueryDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<UserQuery> findAll() {
		CriteriaQuery<UserQuery> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(
				UserQuery.class);
		Root<UserQuery> from = criteriaQuery.from(UserQuery.class);
		criteriaQuery.select(from);
		return entityManager.createQuery(criteriaQuery).getResultList();
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
