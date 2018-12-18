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
	String wrongInput = "**************Please enter a valid input**************\n";

	public void searchInput(Long userid) {
		System.out.println("--------------Restaurant Selection Platform--------------");

		System.out.print("\nLocations available for search: \n");
		RestaurantDetailsCRUD rDetailsCRUD = new RestaurantDetailsCRUD();
		List<String> regionList = rDetailsCRUD.fetchAllRestaurantRegion();
		for (int i = 0; i < regionList.size(); i++) {
			System.out.println(i + 1 + "." + regionList.get(i));
		}

		System.out.println("0. Go back to main menu");
		System.out.println("\nInput Choice of location :");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			if (choice == 0) {
				LoginSession.loadMenu();
			} else {
				region = regionList.get(choice - 1);
				askToSearch(region, userid);
			}

			input.close();
		} catch (Exception e) {
			System.out.println("\n" + wrongInput + "n");
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
			System.out.println("\n" + wrongInput + "\n");
			log.appendToFile(e);
		}

	}

	private void displayRestaurants(String search, String region, Long userid) {
		System.out.println("\n");
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
				System.out.println("\n" + wrongInput + "\n");
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
				System.out.println("\n" + wrongInput + "\n");
				log.appendToFile(e);
			}
		}
	}

	private void makeSelection(List<RestaurantDetails> restaurantDetails, int choice, Long userid) {
		if (choice <= restaurantDetails.size() && choice != 0) {
			rDetailsSelect.displayRestaurantDetails(restaurantDetails.get(choice - 1).getRestaurantId(), userid);
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
			System.out.println("\n" + wrongInput + "\n");
			log.appendToFile(e);
		}
	}

	private void applyFiltersOnRestaurants(List<RestaurantDetails> restaurantDetails, boolean vFlag, Long userid) {

		System.out.println("\n");
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
			System.out.println("\n" + wrongInput + "\n");
			log.appendToFile(e);
		}

	}

	private void makeSelectionFilter(List<RestaurantDetails> restaurantDetails, int choice, Long userid) {
		if (choice <= restaurantDetails.size() && choice != 0) {
			rDetailsSelect.displayRestaurantDetails(restaurantDetails.get(choice - 1).getRestaurantId(), userid);
		} else if (choice == 0) {
			searchInput(userid);
		}
	}

	public List<RestaurantDetails> fetchRestaurantsOnSearch(String search, String region) {
		RestaurantDetailsCRUD restaurantDetails = new RestaurantDetailsCRUD();
		List<RestaurantDetails> listofRestaurantDetails = restaurantDetails.fetchRestaurantDetailsOnSearch(search,
				region);

		DishCRUD dishCRUD = new DishCRUD();
		RestaurantDishCRUD rDishCRUD = new RestaurantDishCRUD();

		List<DishDetails> listOfDishDetails = dishCRUD.listOfDishOnSearch(search);
		if (listOfDishDetails != null)
			for (int i = 0; i < listOfDishDetails.size(); i++) {
				RestaurantDish restaurantDish = rDishCRUD.restaurantDishOnDishId(listOfDishDetails.get(i).getDishId());
				if (restaurantDish != null) {
					RestaurantDetails restaurantDetail = restaurantDetails
							.listOfRestaurantDetailsOnRestaurantId(restaurantDish.getRestaurantId());
					if (restaurantDetail.getCity().equals(region)) {
						listofRestaurantDetails.add(restaurantDetail);
					}
				}
			}

		return listofRestaurantDetails;
	}

}
