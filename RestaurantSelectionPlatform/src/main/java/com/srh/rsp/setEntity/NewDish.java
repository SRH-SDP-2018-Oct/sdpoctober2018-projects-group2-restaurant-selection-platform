package com.srh.rsp.setEntity;

import java.util.Currency;

import javax.persistence.EntityManager;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.DishDetails;

public class NewDish {
	String dishname, dishdescription, picturelink;
	boolean dishtype;
	Currency currencyunit;
	float calories, price;

	public void setNewDish(String dishname, String dishdescription, String picturelink, boolean dishtype,
			Currency currencyunit, float calories, float price) {
		DishDetails dishDetails = new DishDetails();

		dishDetails.setDishName(dishname);
		dishDetails.setDishDescription(dishdescription);
		dishDetails.setPictureLink(picturelink);
		dishDetails.setDishType(dishtype);
		dishDetails.setCurrency_Unit(currencyunit);
		dishDetails.setCalories(calories);
		dishDetails.setPrice(price);

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(dishDetails);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
	}
}
