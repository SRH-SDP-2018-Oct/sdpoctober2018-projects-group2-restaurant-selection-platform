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
	String region, ssearch;

	public void searchInput(Long userid) {
		System.out.println("--------------Restaurant Selection Platform--------------");

		System.out.print("Please choose a location for search: ");
		RestaurantDetailsCRUD rDetailsCRUD = new RestaurantDetailsCRUD();
		List<String> regionList = rDetailsCRUD.fetchAllRestaurantRegion();
		for (int i = 0; i < regionList.size(); i++) {
			System.out.println(i + 1 + "." + regionList.get(i));
		}
		System.out.println("\nEnter Choice");
		Scanner input = new Scanner(System.in);
		try {
			region = regionList.get(Integer.parseInt(input.nextLine()));
			askToSearch(region, userid);
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			// log.appendToFile(e);
		}

	}

	private void askToSearch(String region, Long userid) {
		System.out.println("Search Dish or Restaurant: ");
		Scanner search = new Scanner(System.in);
		try {
			// call method search.nextline
			displayRestaurants(search.nextLine(), region);
			search.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			// log.appendToFile(e);
		}

	}

	private void displayRestaurants(String search, String region) {
		List<RestaurantDetails> restaurantDetails = fetchRestaurantsOnSearch(search, region);
		for (int i = 0; i < restaurantDetails.size(); i++) {
			System.out.println(i + 1 + ". " + restaurantDetails.get(i).getRestaurantName());
		}
		System.out.println("******************************");
		System.out.println(restaurantDetails.size() + 1 + ". Apply Further Filters \n0. Return to Main Menu ");
		System.out.print("\nEnter choice: ");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			makeSelection(restaurantDetails, choice);
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
		}

	}

	private void makeSelection(List<RestaurantDetails> restaurantDetails, int choice) {
		if (choice <= restaurantDetails.size() && choice != 0) {
			RestaurantDetails rdetails = new RestaurantDetails();
			// call Restaurant view with restaurant id
		} else if (choice == 0) {
			// call main menu

		} else {
			chooseFiltersOnRestaurants(restaurantDetails);
		}

	}

	private void chooseFiltersOnRestaurants(List<RestaurantDetails> restaurantDetails) {
		boolean vFlag = true;
		System.out.print("Do you need to display only Veg hotels ?(Enter Y (Yes) / N (NO): ");
		Scanner input = new Scanner(System.in);
		try {
			char choice = input.nextLine().charAt(0);
			switch (choice) {
			case 'Y':
			case 'y':
				vFlag = false;
			case 'N':
			case 'n':
				vFlag = true;
			default:
				System.out.println("Wrong Input");
			}
			applyFiltersOnRestaurants(restaurantDetails, vFlag);
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");

		}

		/*
		 * System.out.print("Need Party Space ?"); Scanner partyFlag = new
		 * Scanner(System.in); try { partyFlag.close(); } catch (Exception e) {
		 * 
		 * }
		 * 
		 * System.out.print("Pets allowed ?"); Scanner petFlag = new Scanner(System.in);
		 * try { petFlag.close(); } catch (Exception e) {
		 * 
		 * }
		 */
	}

	private void applyFiltersOnRestaurants(List<RestaurantDetails> restaurantDetails, boolean vFlag) {
		for (int i = 0; i < restaurantDetails.size(); i++) {
			if (vFlag == true)
				System.out.println(i + 1 + ". " + restaurantDetails.get(i).getRestaurantName());
			else if (restaurantDetails.get(i).isVegNon() == false)
				System.out.println(i + 1 + ". " + restaurantDetails.get(i).getRestaurantName());
		}
		System.out.println("******************************");
		System.out.println("\n0. Return to Main Menu ");
		System.out.print("\nEnter choice: ");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			makeSelectionFilter(restaurantDetails, choice);
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
		}

	}

	private void makeSelectionFilter(List<RestaurantDetails> restaurantDetails, int choice) {
		if (choice <= restaurantDetails.size() && choice != 0) {
			RestaurantDetails rdetails = new RestaurantDetails();
			// call Restaurant view with restaurant id
		} else if (choice == 0) {
			// call main menu

		}

	}

	public List<RestaurantDetails> fetchRestaurantsOnSearch(String search, String region) {

		// veg_non - filter
		// partyspace. - filter
		// petsallowed - filter
		// rating - filter
		RestaurantDetailsCRUD restaurantDetails = new RestaurantDetailsCRUD();

		List<RestaurantDetails> listofRestaurantDetails = restaurantDetails.fetchRestaurantDetailsOnSearch(search,
				region);
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
					if (restaurantDetail.getRegion() == region) {
						listofRestaurantDetails.add(restaurantDetail);
					}

				}
			});
		return listofRestaurantDetails;
	}

	// private void updateSearchHit(long reservationId) {
	// TODO Auto-generated method stub

//	}

	private void printRestaurantsForRegion(String region) {
		RestaurantDetailsCRUD rDetailsCRUD = new RestaurantDetailsCRUD();
		System.out.print("Please choose a restaurant: ");
		List<RestaurantDetails> listOfRestaurantDetails = rDetailsCRUD.fetchRestaurantDetailsOnRegion(region);
		for (int i = 0; i < listOfRestaurantDetails.size(); i++) {
			System.out.println(i + 1 + "." + listOfRestaurantDetails.get(i).getRestaurantName());
		}
		System.out.println("\nEnter Choice");
		Scanner input = new Scanner(System.in);
		try {
			int choiceRestaurant = Integer.parseInt(input.nextLine());
			Long restaurantId = listOfRestaurantDetails.get(choiceRestaurant).getRestaurantId();
			RestaurantDetailsSelect restaurantDetailsSelect = new RestaurantDetailsSelect();
			// Call method to proceed fruther with restaurantId and CustomerLogin
			// information
			input.close();
		} catch (Exception e) {
		}
	}

}
