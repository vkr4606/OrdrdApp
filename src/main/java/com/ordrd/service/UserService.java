package com.ordrd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordrd.dao.UserDAO;
import com.ordrd.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public User findById(int userId) {
		return userDAO.findById(userId);
	}

	@Transactional
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Transactional
	public void insert(User user) {
		userDAO.insert(user);
	}

	@Transactional
	public User update(User user) {
		return userDAO.update(user);
	}

	@Transactional
	public void delete(int userId) {
		User user = userDAO.findById(userId);
		userDAO.delete(user);
	}

}
