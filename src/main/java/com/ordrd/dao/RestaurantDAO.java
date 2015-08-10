package com.ordrd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ordrd.model.Restaurant;
import com.ordrd.variableObject.RestaurantFilter;

@Repository
public class RestaurantDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Restaurant> findAll() {
		CriteriaQuery<Restaurant> createQuery = entityManager.getCriteriaBuilder().createQuery(
				Restaurant.class);
		Root<Restaurant> from = createQuery.from(Restaurant.class);
		createQuery.select(from);
		return entityManager.createQuery(createQuery).getResultList();
	}

	public Restaurant findById(int restaurantId) {
		return entityManager.find(Restaurant.class, restaurantId);
	}

	public void insert(Restaurant restaurant) {
		entityManager.persist(restaurant);
	}

	public Restaurant update(Restaurant restaurant) {
		return entityManager.merge(restaurant);
	}

	public void delete(Restaurant restaurant) {
		entityManager.remove(restaurant);
	}

	/**
	 * getRestaurantListToDisplay
	 * @param restaurantFilter
	 * @return List<Restaurant>
	 * Description - 
	 */
	@SuppressWarnings("unchecked")
	public List<Restaurant> getRestaurantList(RestaurantFilter restaurantFilter)
	{
		List<Restaurant> restaurantList=null;
		String query;
		query="select p from Restaurant p where p.activeFlag=:activeFlag ";

		if(restaurantFilter.getNonVegFlag()!=null && !restaurantFilter.getNonVegFlag().equals(0))
		{
			/**
			 * nonVegFlag=2 means filter out the Non-Veg Restaurants
			 * nonVegFlag=1 means filter out the veg Restaurants
			 */
			query=query+" and p.nonVegFlag=:nonVegFlag ";
		}
		if(restaurantFilter.getAlcoholFLag()!=null)
		{
			/**
			 * alcoholFlag=1 means filter out the Restaurants serving Alcohol
			 */
			query=query+" and p.alcoholFlag=:alcoholFlag ";
		}
		if(restaurantFilter.getLocationIdList()!=null && !restaurantFilter.getLocationIdList().isEmpty())
		{
			/**
			 * if LocationList is present apply the location Filter
			 */
			query=query+" and p.location.id in (:ids) ";
		}
		if(restaurantFilter.getPriceSort()!=null && !restaurantFilter.getPriceSort().equals(0))
		{
			/**
			 * If priceSort Flag is present, sort by Price Range
			 */
			query=query+" order by p.priceRange.codeValue asc"; 
		}

		Query queryString = entityManager.createQuery(query);
		/**
		 * activeFlag is 1 for Active Restaurants
		 */
		queryString.setParameter("activeFlag", 1);
		if(restaurantFilter.getNonVegFlag()!=null && !restaurantFilter.getNonVegFlag().equals(0))
		{
			queryString.setParameter("nonVegFlag", restaurantFilter.getNonVegFlag());
		}
		if(restaurantFilter.getAlcoholFLag()!=null)
		{
			queryString.setParameter("alcoholFlag", restaurantFilter.getAlcoholFLag());
		}
		if(restaurantFilter.getLocationIdList()!=null && !restaurantFilter.getLocationIdList().isEmpty())
		{
			queryString.setParameter("ids", restaurantFilter.getLocationIdList());
		}

		restaurantList=queryString.getResultList();
		System.out.println("Restaurant Details- "+restaurantList.toString());
		return restaurantList;
	}
}
