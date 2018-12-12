package com.srh.rsp;

import java.util.List;
import java.util.Scanner;

import com.srh.rsp.dbAccess.DishCRUD;
import com.srh.rsp.dbAccess.RestaurantDetailsCRUD;
import com.srh.rsp.dbAccess.RestaurantDishCRUD;
import com.srh.rsp.entity.DishDetails;
import com.srh.rsp.entity.RestaurantDetails;
import com.srh.rsp.entity.RestaurantDish;

import LogException.WriteExceptionToFile;

public class SearchFunction {
	String region, ssearch;
	RestaurantDetailsSelect rDetailsSelect = new RestaurantDetailsSelect();
	WriteExceptionToFile log = new WriteExceptionToFile();

	public void searchInput(Long userid) {
		System.out.println("--------------Restaurant Selection Platform--------------");

		System.out.print("\nLocations available for search: ");
		RestaurantDetailsCRUD rDetailsCRUD = new RestaurantDetailsCRUD();
		List<String> regionList = rDetailsCRUD.fetchAllRestaurantRegion();
		for (int i = 0; i < regionList.size(); i++) {
			System.out.println(i + 1 + "." + regionList.get(i));
		}
		System.out.println("\nInput Choice of location");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			region = regionList.get(choice - 1);
			askToSearch(region, userid);
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}

	}

	private void askToSearch(String region, Long userid) {
		System.out.println("\nSearch Dish or Restaurant: \n");
		Scanner search = new Scanner(System.in);
		try {
			displayRestaurants(search.nextLine(), region, userid);
			search.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}

	}

	private void displayRestaurants(String search, String region, Long userid) {
		List<RestaurantDetails> restaurantDetails = fetchRestaurantsOnSearch(search, region);
		if (restaurantDetails.isEmpty()) {
			System.out.println("\n No restaurants for that search");
			System.out.println("\n**********************************");
			System.out.println("\n0. Go back to search");
			System.out.print("Enter Choice: ");
			Scanner input = new Scanner(System.in);
			try {
				int choice = Integer.parseInt(input.nextLine());
				if (choice == 0)
					searchInput(userid);
				input.close();
			} catch (Exception e) {
				System.out.println("\n**************Please enter a valid input**************\n");
				log.appendToFile(e);
			}
		} else {
			for (int i = 0; i < restaurantDetails.size(); i++) {
				System.out.println(i + 1 + ". " + restaurantDetails.get(i).getRestaurantName());
			}
			System.out.println("\n******************************");
			int number = restaurantDetails.size() + 1;
			System.out.println("\n" + number + ". Apply Further Filters \n0. Return to search ");
			System.out.print("\nEnter choice: ");
			Scanner input = new Scanner(System.in);
			try {
				int choice = Integer.parseInt(input.nextLine());
				makeSelection(restaurantDetails, choice, userid);
				input.close();
			} catch (Exception e) {
				System.out.println("\n**************Please enter a valid input**************\n");
				log.appendToFile(e);
			}
		}
	}

	private void makeSelection(List<RestaurantDetails> restaurantDetails, int choice, Long userid) {
		if (choice <= restaurantDetails.size() && choice != 0) {
			rDetailsSelect.displayRestaurantDetails(restaurantDetails.get(choice).getRestaurantId(), userid);
		} else if (choice == 0) {
			searchInput(userid);
		} else {
			chooseFiltersOnRestaurants(restaurantDetails, userid);
		}

	}

	private void chooseFiltersOnRestaurants(List<RestaurantDetails> restaurantDetails, Long userid) {
		boolean vFlag = true;
		System.out.print("\nDo you need to display only Veg hotels ?(Enter Y (Yes) / N (NO): \n");
		Scanner input = new Scanner(System.in);
		try {
			char choice = input.nextLine().charAt(0);
			switch (choice) {
			case 'Y':
			case 'y':
				vFlag = false;
				break;
			case 'N':
			case 'n':
				vFlag = true;
				break;
			default:
				System.out.println("Wrong Input");
				break;
			}
			applyFiltersOnRestaurants(restaurantDetails, vFlag, userid);
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void applyFiltersOnRestaurants(List<RestaurantDetails> restaurantDetails, boolean vFlag, Long userid) {
		for (int i = 0; i < restaurantDetails.size(); i++) {
			if (vFlag == true)
				System.out.println(i + 1 + ". " + restaurantDetails.get(i).getRestaurantName());
			else if (restaurantDetails.get(i).isVegNon() == false)
				System.out.println(i + 1 + ". " + restaurantDetails.get(i).getRestaurantName());
		}
		System.out.println("\n******************************");
		System.out.println("\n0. Return to search ");
		System.out.print("\nEnter choice: ");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			makeSelectionFilter(restaurantDetails, choice, userid);
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}

	}

	private void makeSelectionFilter(List<RestaurantDetails> restaurantDetails, int choice, Long userid) {
		if (choice <= restaurantDetails.size() && choice != 0) {
			rDetailsSelect.displayRestaurantDetails(restaurantDetails.get(choice).getRestaurantId(), userid);
		} else if (choice == 0) {
			searchInput(userid);
		}
	}

	public List<RestaurantDetails> fetchRestaurantsOnSearch(String search, String region) {
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
			log.appendToFile(e);
		}
	}
}
