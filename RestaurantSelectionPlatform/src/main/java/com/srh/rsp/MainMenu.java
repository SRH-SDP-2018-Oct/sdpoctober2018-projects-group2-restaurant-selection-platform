package com.srh.rsp;

import java.io.*;
import java.util.Scanner;

import com.srh.rsp.Restaurant.UpdateRestaurant;

import LogException.WriteExceptionToFile;

public class MainMenu {
	WriteExceptionToFile log = new WriteExceptionToFile();

	public void CustomerMainMenu() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("Please proceed with below options:");
		System.out.println("1. Search Restaurant \n2. Notifications \n3. Settings \n0. Exit");
		System.out.println("\nEnter Choice");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			CustomerMainSelection(choice);
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void CustomerMainSelection(int choice) {
		switch (choice) {
		case 1:
			SearchRestaurant();
			break;
		case 2:
			CustomerNotificaitons();
			break;
		case 3:
			CustomerSettings();
			break;
		case 0:
			System.exit(0);
			break;
		default:
			System.out.println("Wrong input");
		}
	}

	public void OwnerMainMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("Please proceed with below options:");
		System.out.println(
				"1. Add/Delete Restaurant \n2. Generate Report \n3. Manage Bookings \n4. Notifications \n5. Settings \n0. Exit");
		System.out.println("\nEnter Choice");
		try {
			int choice = Integer.parseInt(input.nextLine());
			OwnerMainSelection(choice);
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void OwnerMainSelection(int choice) {
		switch (choice) {
		case 1:
			AddDeleteRestaurant();
			break;
		case 2:
			GenerateReport();
			break;
		case 3:
			ManageBookings();
			break;
		case 4:
			OwnerNotificaitons();
			break;
		case 5:
			OwnerSettings();
			break;
		case 0:
			System.exit(0);
			break;
		default:
			System.out.println("Wrong input");
		}
	}

	public void DualUserMainMenu() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("Please proceed with below options:");
		System.out.println("1. Add/Delete Restaurant \n2. Generate Report \n3. Search Restaurant \n4. Manage Bookings");
		System.out.println("n5. Notifications \n6.Settings \n0. Exit");
		System.out.println("\nEnter Choice");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			DualUserMainSelection(choice);
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void DualUserMainSelection(int choice) {
		switch (choice) {
		case 1:
			AddDeleteRestaurant();
			break;
		case 2:
			GenerateReport();
			break;
		case 3:
			SearchRestaurant();
			break;
		case 4:
			ManageBookings();
			break;
		case 5:
			DualUserNotifications();
			break;
		case 6:
			DualUserSettings();
			break;
		case 0:
			System.exit(0);
			break;
		default:
			System.out.println("Wrong input");
		}
	}

	private void SearchRestaurant() {
		System.out.println("--------------Restaurant Selection Platform--------------");
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
	}

	private void MakeSelection(int choice, String location) {
		switch (choice) {
		case 1: // Restaurant Selection
			break;
		case 2:
			FilterMenu(location);
			break;
		case 0:
			CustomerMainMenu();
			break;
		default:
			System.out.println("Wrong input");
		}
	}

	private void CustomerNotificaitons() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Notifications--------------");
	}

	private void CustomerSettings() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Settings Menu--------------");
		System.out.println("1. Edit Profile \n0. Return to Main Menu");
		System.out.print("\nEnter choice: ");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			switch (choice) {
			case 1:
				UpdateProfile profile = new UpdateProfile();
				profile.UserProfile();
				break;
			case 0:
				CustomerMainMenu();
				break;
			default:
				System.out.println("Wrong input");
			}
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void AddDeleteRestaurant() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Add/Delete Restaurant--------------");
		System.out.println("Please make a selection..");
		System.out.println("1. Add Restaurant \n2. Delete Restaurant \n0. Return to main menu");
		System.out.print("\nEnter choice: ");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			switch (choice) {
			case 1:
				UpdateRestaurant addRestaurant = new UpdateRestaurant();
				addRestaurant.AddRestaurant();
				break;
			case 2: // Delete restaurant functionality
				break;
			case 0:
				OwnerMainMenu();
				break;
			}
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void GenerateReport() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Reporting Page for Owner--------------");
		System.out.println("Please proceed with below options..");
		System.out.println("1. Daily Reports \n2. Monthly Reports \n3. Custom Date Range \n0. Return to Main Menu");
		System.out.print("\nEnter choice: ");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			ReportDateSelection(choice);
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void ReportDateSelection(int choice) {
		
		switch (choice) {
		case 1: // Daily Report functionality
			break;
		case 2: // Monthly Report functionality
			break;
		case 3:
			System.out.println("Please Enter Date Range in dd/MM/YYYY format");
			CustomReportDate();
			break;
		case 0:
			OwnerMainMenu();
			break;
		default:
			System.out.println("Wrong input.");
		}
	}
	
	private void CustomReportDate() {
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("From: ");
			String fromDate = input.nextLine();
			System.out.print("To: ");
			String toDate = input.nextLine();
			
			// Custom Report functionality
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
		input.close();
	}

	private void ManageBookings() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Manage Bookings--------------");
	}

	private void OwnerNotificaitons() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Notifications--------------");
	}

	private void OwnerSettings() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Settings--------------");
		System.out.println("1. Edit Restaurant Details \n2. Edit Profile \n0. Return to main menu");
		System.out.print("\nEnter choice: ");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			switch (choice) {
			case 1: // Edit restaurant functionality
				break;
			case 2:
				UpdateProfile profile = new UpdateProfile();
				profile.UserProfile();
				break;
			case 0:
				OwnerMainMenu();
				break;
			}
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void DualUserNotifications() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Notifications--------------");
	}

	private void DualUserSettings() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Settings--------------");
		System.out.println("1. Edit Restaurant Details \n2. Edit Profile \n0. Return to main menu");
		System.out.print("\nEnter choice: ");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			switch (choice) {
			case 1: // Edit restaurant functionality
				break;
			case 2:
				UpdateProfile profile = new UpdateProfile();
				profile.UserProfile();
				break;
			case 0:
				DualUserMainMenu();
				break;
			}
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	public void FilterMenu(String location) {
		System.out.println("Filter your search result:");
		System.out.println("1. Cuisines \n2. Distance \n3. Type of Restaurants \n4. Ratings \n0. Back to Main Menu");
		System.out.print("\nEnter choice: ");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
	        int choice = Integer.parseInt(bufferedReader.readLine());
			enterFilter(choice, location);
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void enterFilter(int choice, String location) {
		Filters filter = new Filters();
		switch (choice) {
		case 1:
			filter.CuisineFilter(location);
			break;
		case 2:
			filter.DistanceFilter(location);
			break;
		case 3:
			filter.TypeFilter(location);
			break;
		case 4:
			filter.RatingsFilter(location);
			break;
		case 0:
			CustomerMainMenu();
			break;
		}
	}
}
