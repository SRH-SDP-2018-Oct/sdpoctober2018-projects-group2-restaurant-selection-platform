package com.srh.rsp;

import java.util.List;
import java.util.Scanner;

import com.srh.rsp.dbAccess.DishCRUD;
import com.srh.rsp.dbAccess.RestaurantDetailsCRUD;
import com.srh.rsp.dbAccess.RestaurantDishCRUD;
import com.srh.rsp.entity.DishDetails;
import com.srh.rsp.entity.RestaurantDetails;
import com.srh.rsp.entity.RestaurantDish;

public class SearchFunction {

	public void searchInput() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("Search Dish or Restaurant: ");
		Scanner search = new Scanner(System.in);
		
		System.out.print("Please enter location for search: ");
		Scanner input = new Scanner(System.in);
		try {
			String location = input.nextLine();
			// Search results in location
			
			System.out.println("\n1. Select Restaurant \n2. Apply Filters \n0. Return to Main Menu ");
			System.out.print("\nEnter choice: ");
			int choice = Integer.parseInt(input.nextLine());
			MakeSelection(choice, location);
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
	}
	public List<RestaurantDetails> fetchRestaurantsOnSearch(String search) {

		// veg_non - filter
		// partyspace. - filter
		// petsallowed - filter
		// rating - filter
		RestaurantDetailsCRUD restaurantDetails = new RestaurantDetailsCRUD();

		List<RestaurantDetails> listofRestaurantDetails = restaurantDetails.fetchRestaurantDetailsOnSearch(search);
		// if (listofRestaurantDetails != null)

		// listofRestaurantDetails.forEach(restaurant -> {
		// call searchhit entity for updation
		// updateSearchHit(restaurant.getRestaurantId());

		// });

		// this section is for checking dishes table for matching dishname
		DishCRUD dishCRUD = new DishCRUD();
		RestaurantDishCRUD rDishCRUD = new RestaurantDishCRUD();

		List<DishDetails> listOfDishDetails = dishCRUD.listOfDishOnSearch(search);
		if (listOfDishDetails != null)

			listOfDishDetails.forEach(dishId -> {
				// call searchhit entity for updation
				RestaurantDish restaurantDish = rDishCRUD.restaurantDishOnDishId(dishId.getDishId());
				if (restaurantDish != null) {
					RestaurantDetails restaurantDetail = restaurantDetails
							.listOfRestaurantDetailsOnRestaurantId(restaurantDish.getRestaurantId());
					listofRestaurantDetails.add(restaurantDetail);
				}
			});
		return listofRestaurantDetails;
	}

	// private void updateSearchHit(long reservationId) {
	// TODO Auto-generated method stub

//	}

}
