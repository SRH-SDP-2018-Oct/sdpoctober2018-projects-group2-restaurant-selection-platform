package com.srh.rsp.Restaurant;

import java.util.Scanner;

import com.srh.rsp.LoginSession;
import com.srh.rsp.dbAccess.CuisineCRUD;
import com.srh.rsp.dbAccess.DishCRUD;
import com.srh.rsp.dbAccess.RestaurantCuisineCRUD;
import com.srh.rsp.dbAccess.RestaurantDishCRUD;
import com.srh.rsp.entity.CusineType;
import com.srh.rsp.entity.DishDetails;

import LogException.WriteExceptionToFile;

public class CusineDishes {
	WriteExceptionToFile log = new WriteExceptionToFile();
	public static long dishID;

	public void AddCusine(RestaurantData newRestaurant) {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Add Cuisines--------------");
		Scanner input = new Scanner(System.in);
		int choice = 1;
		try {
			do {
				newCusine(newRestaurant);
				System.out.println("Press 0 to stop adding cusines or 1 to continue adding\n\n");
				choice = Integer.parseInt(input.nextLine());
			} while (choice != 0);
			AddDishes(newRestaurant.restaurantName);
		} catch (Exception e) {
			System.out.println("Please enter a valid input 0 to exit");
			log.appendToFile(e);
		}
	}

	public void newCusine(RestaurantData newRestaurant) {
		try {
			Scanner input = new Scanner(System.in);
			long cusineID;
			CuisineCRUD allCusines = new CuisineCRUD();
			for(CusineType listItem : allCusines.litsOfCusine())
			    System.out.println("\n" + listItem);
			
			System.out.println("Enter the Cusine ID from above to add: ");
			cusineID = Long.parseLong(input.nextLine());
			RestaurantCuisineCRUD cusineToRestaurant = new RestaurantCuisineCRUD();
			CusineType cusineDetail = allCusines.cusineName(cusineID);
			String cuisinename = cusineDetail.getCusineName();
			cusineToRestaurant.setRestaurantCuisine(UpdateRestaurant.restaurantID, cusineID, newRestaurant.restaurantName, cuisinename );
			System.out.println("Cusine added");
		} catch (NumberFormatException e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void AddDishes(String restaurantName) {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Add Dishes--------------");
		int choice = 1;
		try {
			Scanner input = new Scanner(System.in);
			do {
				addNewDish(restaurantName);
				System.out.println("Press 0 to stop adding dishes or 1 to add dish: ");
				choice = input.nextInt();
			} while (choice != 0);
			LoginSession.loadMenu();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
			System.exit(0);
		}
	}
	
	private void AddDishToRestaurant(String restaurantName, String dishName) {
		RestaurantDishCRUD dishRestaurant = new RestaurantDishCRUD();
		dishRestaurant.setRestaurantDish(UpdateRestaurant.restaurantID, dishID, restaurantName, dishName);
		
		RestaurantOffers offers = new RestaurantOffers();
		offers.addOffer();
	}

	private void addNewDish(String restaurantName) {
		Scanner input = new Scanner(System.in);
		DishData dish = new DishData();
		dish.dishName = enterDishName(input);
		dish.dishDescription = enterDescription(input);
		dish.picture = enterPictureLink(input);
		dish.currencyUnit = enterCurrencyUnit(input);
		dish.dishType = enterDishType(input);
		dish.price = enterPrice(input);
		dish.calories = enterCalories(input);
		
		DishCRUD newDish = new DishCRUD();
		newDish.setNewDish(dish.dishName, dish.dishDescription, dish.picture, dish.dishType, dish.currencyUnit, (float) dish.calories, (float) dish.price);
		System.out.println("Dish added");
		DishDetails getID = newDish.getDishID(dish.dishName);
		dishID = getID.getDishId();
		AddDishToRestaurant(restaurantName, dish.dishName);
	}
	
	private boolean enterDishType(Scanner input) {
		System.out.print("Is it a Non-Veg dish? (Enter Y (Yes) / N (NO)): ");
		try {
			char choice = input.nextLine().charAt(0);
			switch (choice) {
			case 'Y':
			case 'y':
				return true;
			case 'N':
			case 'n':
				return false;
			default:
				System.out.println("Wrong Input");
			}
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
		return false;
	}

	private String enterCurrencyUnit(Scanner input) {
		System.out.print("Enter Currency unit: ");
		return input.nextLine();
	}

	private String enterDishName(Scanner input) {
		System.out.print("Enter dish name: ");
		return input.nextLine();
	}
	
	private String enterDescription(Scanner input) {
		System.out.print("Enter dish description: ");
		return input.nextLine();
	}
	
	private String enterPictureLink(Scanner input) {
		System.out.print("Enter picture link for the dish: ");
		return input.nextLine();
	}
	
	private Double enterPrice(Scanner input) {
		try {
			System.out.print("Enter price of dish: ");
			return Double.parseDouble(input.nextLine());
		} catch(Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
		return null;
	}
	
	private Double enterCalories(Scanner input) {
		try {
			System.out.print("Enter calories in the dish: ");
			return Double.parseDouble(input.nextLine());
		} catch(Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
		return null;
	}
}
