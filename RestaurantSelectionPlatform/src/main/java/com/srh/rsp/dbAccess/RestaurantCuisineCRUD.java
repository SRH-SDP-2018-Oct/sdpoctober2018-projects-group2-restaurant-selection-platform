package com.srh.rsp.dbAccess;

import javax.persistence.EntityManager;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.RestaurantCusine;

public class RestaurantCuisineCRUD {
	long restaurantid, cusineid;
	String restaurantname, cuisinename;

	public void setRestaurantCuisine(long restaurantid, long cuisineid, String restaurantname, String cuisinename) {

		RestaurantCusine restaurantCusine = new RestaurantCusine();
		restaurantCusine.setRestaurantId(restaurantid);
		restaurantCusine.setRestaurantId(restaurantid);
		restaurantCusine.setRestaurantName(restaurantname);
		restaurantCusine.setCuisineName(cuisinename);

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(restaurantCusine);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
	}
}
