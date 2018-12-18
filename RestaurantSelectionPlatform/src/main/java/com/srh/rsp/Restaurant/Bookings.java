package com.srh.rsp.Restaurant;

import java.util.List;
import java.util.Scanner;

import com.srh.rsp.LoginSession;
import com.srh.rsp.dbAccess.RestaurantDetailsCRUD;
import com.srh.rsp.dbAccess.RestaurantReservationCRUD;
import com.srh.rsp.entity.RestaurantDetails;
import com.srh.rsp.entity.RestaurantReservation;

import LogException.WriteExceptionToFile;

public class Bookings {
	WriteExceptionToFile log = new WriteExceptionToFile();

	public void showBookings() {
		RestaurantDetailsCRUD restaurants = new RestaurantDetailsCRUD();
		List<RestaurantDetails> restaurantIDs = restaurants.listOfRestaurantDetailsOnCustomerId(LoginSession.userID);
		RestaurantReservationCRUD reservation = new RestaurantReservationCRUD();
		List<RestaurantReservation> reservationDetails = null;
		if (restaurantIDs != null) {
			for (RestaurantDetails listItem : restaurantIDs) {
				reservationDetails = reservation.getRestaurantReservation(listItem.getRestaurantId());
				if (reservationDetails != null)
					for (RestaurantReservation data : reservationDetails) {
						System.out.println("\n" + data);
						decideBooking(data);
					}
				else {
					System.out.println("No pending reservations.");
					LoginSession.loadMenu();
				}
			} 
		}
		else {
			System.out.println("No pending reservations.");
			LoginSession.loadMenu();
		}
	}

	private void decideBooking(RestaurantReservation reservationDetails) {
		Scanner input = new Scanner(System.in);
		String status = null;
		System.out.print("Do you want to accept the booking? (Enter Y (Yes) / N (NO)): ");
		try {
			char choice = input.nextLine().charAt(0);
			switch (choice) {
			case 'Y':
			case 'y':
				status = "Accepted";
				break;
			case 'N':
			case 'n':
				status = "Rejected";
				break;
			default:
				System.out.println("Wrong Input");
			}
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
		updateBooking(status, reservationDetails);
	}

	private void updateBooking(String status, RestaurantReservation data) {
		RestaurantReservationCRUD reservation = new RestaurantReservationCRUD();
		reservation.setReservationStatus(status, data);
		LoginSession.loadMenu();
	}
}
