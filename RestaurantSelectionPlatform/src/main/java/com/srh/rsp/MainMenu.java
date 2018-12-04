package com.srh.rsp;

import java.util.Scanner;

public class MainMenu {
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
			System.out.println(e);
			e.printStackTrace();
		}
	}

	private void CustomerMainSelection(int choice) {
		try {
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
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public void OwnerMainMenu() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("Please proceed with below options:");
		System.out.println("1. Add/Delete Restaurant \n2. Generate Report \n3. Manage Bookings \n4. Notifications \n5.Settings \n0. Exit");
		System.out.println("\nEnter Choice");
		try {
			Scanner input = new Scanner(System.in);
			int choice = Integer.parseInt(input.nextLine());
			OwnerMainSelection(choice);
			input.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	private void OwnerMainSelection(int choice) {
		try {
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
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public void DualUserMainMenu() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("Please proceed with below options:");
		System.out.println("1. Add/Delete Restaurant \n2. Generate Report \n3. Search Restaurant \n4. Manage Bookings");
		System.out.println("n5. Notifications \\n6.Settings \\n0. Exit");
		System.out.println("\nEnter Choice");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
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
			input.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	private void SearchRestaurant() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.print("Please enter location for search: ");
		Scanner input = new Scanner(System.in);
		try {
			String location = input.nextLine();

			input.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
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
			case 1: UpdateProfile profile = new UpdateProfile();
			profile.UserProfile();
			break;
			case 0:
				CustomerMainMenu();
				break;
			}
			input.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	private void AddDeleteRestaurant() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Search Restaurant--------------");
		System.out.println("Please make a selection..");
		System.out.println("1. Add Restaurant \n2. Delete Restaurant \n0. Return to main menu");
		System.out.print("\nEnter choice: ");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			switch (choice) {
			case 1:		//Add restaurant functionality
				break;
			case 2:		//Delete restaurant functionality
				break;
			case 0:
				OwnerMainMenu();
				break;
			}
			input.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
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
			switch (choice) {
			case 1:		//Daily Report functionality
				break;
			case 2: 	//Monthly Report functionality
				break;
			case 3:	System.out.println("Please Enter Date Range in dd/MM/YYYY format");
			System.out.print("From: ");
			String fromDate = input.nextLine();
			System.out.print("To: ");
			String toDate = input.nextLine();
			// Custom Report functionality
			break;
			case 0:
				OwnerMainMenu();
				break;
			}
			input.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
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
			case 1:		//Edit restaurant functionality
				break;
			case 2: UpdateProfile profile = new UpdateProfile();
			profile.UserProfile();
			break;
			case 0:
				OwnerMainMenu();
				break;
			}
			input.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
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
			case 1:		//Edit restaurant functionality
				break;
			case 2:	UpdateProfile profile = new UpdateProfile();
			profile.UserProfile();
			break;
			case 0:
				DualUserMainMenu();
				break;
			}
			input.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	private void FilterMenu() {
		System.out.println("Filter your search result:");
		System.out.println("1. Cuisines \n2. Distance \n3. Type of Restaurants \n4.Ratings \n0. Back to Main Menu");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			switch (choice) {
			case 1:
				break;
			case 2:
				break;
			case 3: 
				break;
			case 4: 
				break;
			case 0:
				CustomerMainMenu();
				break;
			}
			input.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
