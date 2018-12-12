package com.srh.rsp;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

import com.srh.rsp.Restaurant.Bookings;
import com.srh.rsp.Restaurant.UpdateRestaurant;

import LogException.WriteExceptionToFile;
import srh.com.rsp.CustomerFunctionalities.Notifications;

public class MainMenu {
	WriteExceptionToFile log = new WriteExceptionToFile();

	public void CustomerMainMenu() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("Please proceed with below options:");
		System.out.println("1. Search Restaurant \n2. Generate Reports \n3. Notifications \n4. Settings \n0. Exit");
		System.out.print("\nEnter Choice :");
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
			GenerateReport();
			break;
		case 3:
			CustomerNotificaitons();
			break;
		case 4: Settings();
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
		System.out.print("\nEnter Choice: ");
		try {
			int choice = Integer.parseInt(input.nextLine());
			OwnerMainSelection(choice);
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void OwnerMainSelection(int choice) {
		switch (choice) {
		case 1:
			UpdateRestaurant addRestaurant = new UpdateRestaurant();
			addRestaurant.AddRestaurant();
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
			Settings();
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
		System.out.println("1. Add Restaurant \n2. Generate Report \n3. Search Restaurant \n4. Manage Bookings");
		System.out.println("5. Notifications \n6. Settings \n0. Exit");
		System.out.print("\nEnter Choice: ");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			DualUserMainSelection(choice);
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void DualUserMainSelection(int choice) {
		switch (choice) {
		case 1:
			UpdateRestaurant addRestaurant = new UpdateRestaurant();
			addRestaurant.AddRestaurant();
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
			Settings();
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
		try {
			SearchFunction searchPage = new SearchFunction();
			searchPage.searchInput(LoginSession.userID);
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void CustomerNotificaitons() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Notifications--------------");
		Notifications showNotification = new Notifications();
		showNotification.displayNotification();
	}

	private void Settings() {
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
				LoginSession.loadMenu();
				break;
			default:
				System.out.println("Wrong input");
			}
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
		case 1:
			dailyReport();
			break;
		case 2:
			monthlyReport();
			break;
		case 3:
			System.out.println("Please Enter Date Range in YYYY-MM-dd format");
			CustomReportDate();
			break;
		case 0:
			LoginSession.loadMenu();
			break;
		default:
			System.out.println("Wrong input.");
		}
	}
	
	private void dailyReport() {
		// Daily Report functionality
		Date date = Date.valueOf(LocalDate.now());
	}
	
	private void monthlyReport() {
		// Monthly Report functionality
	}

	private void CustomReportDate() {
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("From: ");
			java.util.Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(input.nextLine());
			java.sql.Date dateFrom = new java.sql.Date(fromDate.getTime());
			System.out.print("To: ");
			java.util.Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse(input.nextLine());
			java.sql.Date dateTo = new java.sql.Date(toDate.getTime());
			
			// Custom Report functionality
			
		} catch (ParseException e) {
			System.out.println("\n**************Something went wrong**************\n");
			log.appendToFile(e);
			System.exit(0);
		} catch (NumberFormatException e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
		input.close();
	}

	private void ManageBookings() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Manage Bookings--------------");
		Bookings booking = new Bookings();
		booking.showBookings();
		LoginSession.loadMenu();
	}

	private void OwnerNotificaitons() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Notifications--------------");
	}

	private void DualUserNotifications() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Notifications--------------");
	}
}
