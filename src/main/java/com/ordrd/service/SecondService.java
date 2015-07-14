package com.ordrd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordrd.dao.CustomerDAO;
import com.ordrd.model.Customer;

@Service
public class SecondService {

	@Autowired
	private CustomerDAO customerDAO;

	@Transactional
	public Customer findById(int customerId) {
		Customer customer = customerDAO.findById(customerId);
		return customer;
	}

	@Transactional
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	@Transactional
	public void insert(Customer customer) {
		customerDAO.insert(customer);
	}

	@Transactional
	public void update(Customer customer) {
		customerDAO.update(customer);
	}

	@Transactional
	public void delete(Customer customer) {
		customerDAO.delete(customer);
	}

}
