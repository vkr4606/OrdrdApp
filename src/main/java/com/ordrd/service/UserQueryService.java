package com.ordrd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordrd.dao.UserQueryDAO;
import com.ordrd.model.UserQuery;

@Service
public class UserQueryService {

	@Autowired
	private UserQueryDAO userQueryDAO;

	@Transactional
	public UserQuery findById(int userQueryId) {
		return userQueryDAO.findById(userQueryId);
	}

	@Transactional
	public List<UserQuery> findAll() {
		return userQueryDAO.findAll();
	}

	@Transactional
	public void insert(UserQuery userQuery) {
		userQueryDAO.insert(userQuery);
	}

	@Transactional
	public UserQuery update(UserQuery userQuery) {
		return userQueryDAO.update(userQuery);
	}

	@Transactional
	public void delete(int userQueryId) {
		UserQuery userQuery = userQueryDAO.findById(userQueryId);
		userQueryDAO.delete(userQuery);
	}

}
