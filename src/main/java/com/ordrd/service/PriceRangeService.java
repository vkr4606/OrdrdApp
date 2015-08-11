package com.ordrd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordrd.dao.PriceRangeDAO;
import com.ordrd.model.PriceRange;

@Service
public class PriceRangeService {

	@Autowired
	private PriceRangeDAO priceRangeDAO;

	@Transactional
	public PriceRange findById(int priceRangeId) {
		PriceRange priceRange = priceRangeDAO.findById(priceRangeId);
		return priceRange;
	}

	@Transactional
	public List<PriceRange> findAll() {
		return priceRangeDAO.findAll();
	}

	@Transactional
	public void insert(PriceRange priceRange) {
		priceRangeDAO.insert(priceRange);
	}

	@Transactional
	public PriceRange update(PriceRange priceRange) {
		return priceRangeDAO.update(priceRange);
	}

	@Transactional
	public void delete(int priceRangeId) {
		PriceRange priceRange = priceRangeDAO.findById(priceRangeId);
		priceRangeDAO.delete(priceRange);
	}

}
