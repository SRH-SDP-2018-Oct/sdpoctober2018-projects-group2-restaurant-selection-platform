package com.srh.rsp.dbAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.DishDetails;
import com.srh.rsp.entity.RestaurantDetails;
import com.srh.rsp.entity.RestaurantDish;

public class FetchForSearch {

	public List<RestaurantDetails> fetchRestaurantsOnSearch(String search) {

		// first dishtable for matching dishnames and bring restaurant id
		// update search hits table with D flag
		// fetch corresponding restaurant details
		// search restaurant details table on name and get matching restaurant details
		// update search hits table with R flag
		// restaurant name
		// restaurant id
		// veg_non - filter
		// partyspace. - filter
		// petsallowed - filter
		// rating - filter
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		CriteriaBuilder cbuilder = PersistenceManager.INSTANCE.getCriteriaBuilder();

		// this section see in restauarant details table for matching names

		CriteriaQuery<RestaurantDetails> criteriaQuery = cbuilder.createQuery(RestaurantDetails.class);
		Root<RestaurantDetails> restaurantDetailsRoot = criteriaQuery.from(RestaurantDetails.class);
		criteriaQuery.select(restaurantDetailsRoot);
		criteriaQuery.where(cbuilder.like(restaurantDetailsRoot.<String>get("restaurantName"), search));
		List<RestaurantDetails> listofRestaurantDetails = em.createQuery(criteriaQuery).getResultList();
		if (listofRestaurantDetails != null)

			listofRestaurantDetails.forEach(restaurant -> {
				// call searchhit entity for updation
				updateSearchHit(restaurant.getRestaurantId());

			});

		// this section is for checking dishes table for matching dishname
		DishCRUD dishCRUD = new DishCRUD();
		RestaurantDishCRUD rDishCRUD = new RestaurantDishCRUD();

		List<DishDetails> listOfDishDetails = dishCRUD.listOfDishOnName(search);
		if (listOfDishDetails != null)

			listOfDishDetails.forEach(dish -> {
				// call searchhit entity for updation
				updateSearchHit(dish.getDishId());
				// call restaurantdish entity for getting restaurant ids
				List<RestaurantDish> listOfRestaurantDishDetails = rDishCRUD.listOfRestarantDish(dish.getDishId());
			});
		return listofRestaurantDetails;
	}

	private void updateSearchHit(long reservationId) {
		// TODO Auto-generated method stub

	}

}
