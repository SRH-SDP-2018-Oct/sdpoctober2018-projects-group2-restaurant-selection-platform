package com.srh.rsp.dbAccess;

import java.util.Currency;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.DishDetails;
import com.srh.rsp.entity.RestaurantDetails;

public class DishCRUD {
	String dishname, dishdescription, picturelink;
	boolean dishtype;
	Currency currencyunit;
	float calories, price;
	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
	CriteriaBuilder cbuilder = PersistenceManager.INSTANCE.getCriteriaBuilder();

	public void setNewDish(String dishname, String dishdescription, String picturelink, boolean dishtype,
			String currencyunit, float calories, float price) {
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
	}
	
	public DishDetails getDishID(String dishName) {
		CriteriaQuery<DishDetails> criteriaQuery = cbuilder.createQuery(DishDetails.class);
		Root<DishDetails> dishDetailsRoot = criteriaQuery.from(DishDetails.class);
		criteriaQuery.select(dishDetailsRoot);
		criteriaQuery.where(cbuilder.equal(dishDetailsRoot.get("dishName"), dishName));
		List<DishDetails> dishDetails = em.createQuery(criteriaQuery).getResultList();
		if (dishDetails.isEmpty()) {
			// list is empty
			return null;
		}
		em.close();
		return dishDetails.get(0);
	}

	public List<DishDetails> listOfDishOnSearch(String search) {
		CriteriaQuery<DishDetails> criteriaQuery = cbuilder.createQuery(DishDetails.class);
		Root<DishDetails> dishDetailsRoot = criteriaQuery.from(DishDetails.class);
		criteriaQuery.select(dishDetailsRoot);
		criteriaQuery.where(
				cbuilder.like(cbuilder.lower(dishDetailsRoot.get("dishName")), "%" + search.toLowerCase() + "%"));
		List<DishDetails> listOfDishDetails = em.createQuery(criteriaQuery).getResultList();
		return listOfDishDetails;

	}

	public DishDetails dishDetailsOnId(long dishid) {
		
		CriteriaQuery<DishDetails> criteriaQuery = cbuilder.createQuery(DishDetails.class);
		Root<DishDetails> dishDetailsRoot = criteriaQuery.from(DishDetails.class);
		criteriaQuery.select(dishDetailsRoot);
		criteriaQuery.where(cbuilder.equal(dishDetailsRoot.get("dishId"), dishid));
		List<DishDetails> dishDetails = em.createQuery(criteriaQuery).getResultList();
		if (dishDetails.isEmpty()) {
			// list is empty
			return null;
		}
		em.close();
		return dishDetails.get(0);
	}
}
