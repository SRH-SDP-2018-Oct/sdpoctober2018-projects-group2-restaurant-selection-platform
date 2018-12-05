package com.srh.rspRestaurantUpdate;

import java.util.Scanner;

public class UpdateRestaurant {
	public void AddRestaurant() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Add Restaurant--------------");
		RestaurantData newRestaurant = new RestaurantData();
		System.out.println("Enter Details Below:");
		enterDetails(newRestaurant);
	}
	
	private void enterDetails(RestaurantData newRestaurant) {
		Scanner input = new Scanner(System.in);
		newRestaurant.restaurantName = enterRestaurantName(input);
		newRestaurant.eMailID = enterEmailID(input);
		newRestaurant.phoneNumber = enterPhoneNumber(input);
		newRestaurant.country = enterCountry(input);
		newRestaurant.city = enterCity(input);
		newRestaurant.postalCode = enterPostalCode(input);
		newRestaurant.region = enterRegion(input);
		newRestaurant.houseNumberStreet = enterHouseStreet(input);
		newRestaurant.vegNon = ifVegNonVeg(input);
		newRestaurant.partySpace = ifPartySpace(input);
		newRestaurant.petsAllowed = ifPetsAllowed(input);
		newRestaurant.pictureLink = enterPictureLink(input);
		newRestaurant.subscriptionStatus = enterSubscriptionStatus(input);
		
		input.close();
	}
	
	private String enterRestaurantName(Scanner input) {
		System.out.print("Enter Restaurant Name: ");
		return input.nextLine();
	}
	
	private String enterEmailID(Scanner input) {
		System.out.print("Enter Restaurant Email: ");
		return input.nextLine();
	}
	
	private String enterPhoneNumber(Scanner input) {
		System.out.print("Enter Phone number: ");
		return input.nextLine();
	}
	
	private String enterCountry(Scanner input) {
		System.out.print("Enter Country: ");
		return input.nextLine();
	}
	
	private String enterCity(Scanner input) {
		System.out.print("Enter City: ");
		return input.nextLine();
	}
	
	private String enterPostalCode(Scanner input) {
		System.out.print("Enter postal code: ");
		return input.nextLine();
	}
	
	private String enterRegion(Scanner input) {
		System.out.print("Enter Region: ");
		return input.nextLine();
	}
	
	private String enterHouseStreet(Scanner input) {
		System.out.print("Enter House number, Street: ");
		return input.nextLine();
	}
	
	private Boolean ifVegNonVeg(Scanner input) {
		System.out.print("Does the restaurant serve Non-Veg? (Enter Y (Yes) / N (NO)): ");
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
			ifVegNonVeg(input);
		}
		return null;
	}
	
	private Boolean ifPartySpace(Scanner input) {
		System.out.print("Is party sapce available? (Enter Y (Yes) / N (NO)): ");
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
			ifPartySpace(input);
		}
		return null;
	}
	
	private Boolean ifPetsAllowed(Scanner input) {
		System.out.print("Are pets allowed? (Enter Y (Yes) / N (NO)): ");
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
			ifPetsAllowed(input);
		}
		return null;
	}
	
	private String enterPictureLink(Scanner input) {
		System.out.print("Enter Restaurant picture link: ");
		return input.nextLine();
	}
	
	private int enterSubscriptionStatus(Scanner input) {
		System.out.print("Enter Subscription Status: ");
		try {
			return Integer.parseInt(input.nextLine());	
		}
		catch(Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			enterSubscriptionStatus(input);
		}
		return 0;
	}

}
