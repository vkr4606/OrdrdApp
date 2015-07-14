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
		User User = userDAO.findById(userId);
		return User;
	}

	@Transactional
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Transactional
	public void insert(User User) {
		userDAO.insert(User);
	}

	@Transactional
	public void update(User User) {
		userDAO.update(User);
	}

	@Transactional
	public void delete(User User) {
		userDAO.delete(User);
	}

}
