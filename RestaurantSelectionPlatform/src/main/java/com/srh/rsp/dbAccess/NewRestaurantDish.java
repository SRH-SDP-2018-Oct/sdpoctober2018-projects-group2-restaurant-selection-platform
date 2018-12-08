package com.srh.rsp.dbAccess;

import javax.persistence.EntityManager;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.RestaurantDish;

public class NewRestaurantDish {
	String restaurantname, dishname;
	int restaurantid, dishid;

	public void setRestaurantDish(int restaurantid, int dishid, String restaurantname, String dishname) {

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
		PersistenceManager.INSTANCE.close();

	}

}
