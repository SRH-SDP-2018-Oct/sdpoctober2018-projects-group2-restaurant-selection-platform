package com.srh.rsp.dbAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.RestaurantDish;

public class RestaurantDishCRUD {
	String restaurantname, dishname;
	int restaurantid, dishid;
	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
	CriteriaBuilder cbuilder = PersistenceManager.INSTANCE.getCriteriaBuilder();

	public void setRestaurantDish(long restaurantid, long dishid, String restaurantname, String dishname) {

		RestaurantDish restaurantDish = new RestaurantDish();
		restaurantDish.setRestaurantId(restaurantid);
		restaurantDish.setDishId(dishid);
		restaurantDish.setRestaurantName(restaurantname);
		restaurantDish.setDishName(dishname);

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(restaurantDish);
		em.getTransaction().commit();
		em.close();
	}

	public RestaurantDish restaurantDishOnDishId(Long dishid) {
		CriteriaQuery<RestaurantDish> criteriaQuery = cbuilder.createQuery(RestaurantDish.class);
		Root<RestaurantDish> restaurantDishDetailsRoot = criteriaQuery.from(RestaurantDish.class);
		criteriaQuery.select(restaurantDishDetailsRoot);
		criteriaQuery.where(cbuilder.equal(restaurantDishDetailsRoot.get("dishId"), dishid));
		List<RestaurantDish> listofRestaurantDishDetails = em.createQuery(criteriaQuery).getResultList();
		if (listofRestaurantDishDetails.isEmpty()) {
			// list is empty
			return null;
		}
		return listofRestaurantDishDetails.get(0);

	}

	public List<RestaurantDish> listOfRestaurantDishOnRestaurantId(Long restaurantid) {

		CriteriaQuery<RestaurantDish> criteriaQuery = cbuilder.createQuery(RestaurantDish.class);
		Root<RestaurantDish> restaurantDishRoot = criteriaQuery.from(RestaurantDish.class);
		criteriaQuery.select(restaurantDishRoot);
		criteriaQuery.where(cbuilder.equal(restaurantDishRoot.get("restaurantId"), restaurantid));
		List<RestaurantDish> restaurantDishes = em.createQuery(criteriaQuery).getResultList();
		if (restaurantDishes.isEmpty()) {
			// list is empty
			return null;
		}
		em.close();
		return restaurantDishes;
	}
}
