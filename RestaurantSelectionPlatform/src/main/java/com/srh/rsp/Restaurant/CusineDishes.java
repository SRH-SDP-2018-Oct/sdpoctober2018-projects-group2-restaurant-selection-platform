package com.srh.rsp.Restaurant;

import java.util.Scanner;

import com.srh.rsp.MainMenu;

import LogException.WriteExceptionToFile;

public class CusineDishes {
	WriteExceptionToFile log = new WriteExceptionToFile();

	public void AddCusine(RestaurantData newRestaurant) {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Add Cuisines--------------");
		CusineData cusine = new CusineData();
		Scanner input = new Scanner(System.in);
		int choice = 1;
		try {
			while (choice != 0) {
				newCusine(cusine);
				System.out.println("Press 0 to stop adding cusines or 1 to continue adding");
				choice = Integer.parseInt(input.nextLine());
			}
		} catch (Exception e) {
			System.out.println("Please enter a valid input 0 to exit");
			log.appendToFile(e);
		}
		AddDishes();
	}

	private void newCusine(CusineData cusine) {
		// DB call to fetch cusines
		System.out.println("Cusine added");
	}

	private void AddDishes() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Add Dishes--------------");
		int choice = 1;
		try {
			Scanner input = new Scanner(System.in);
			do {
				addNewDish();
				System.out.println("Press 0 to stop adding dishes or 1 to add dish: ");
				choice = input.nextInt();
			} while (choice != 0);
			MainMenu menu = new MainMenu();
			menu.OwnerMainMenu();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void addNewDish() {
		Scanner input = new Scanner(System.in);
		DishData dish = new DishData();
		dish.dishName = enterDishName(input);
		dish.dishDescription = enterDescription(input);
		dish.picture = enterPictureLink(input);
		dish.price = enterPrice(input);
		dish.calories = enterCalories(input);
		// Add dish to db
		System.out.println("Dish added");
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
