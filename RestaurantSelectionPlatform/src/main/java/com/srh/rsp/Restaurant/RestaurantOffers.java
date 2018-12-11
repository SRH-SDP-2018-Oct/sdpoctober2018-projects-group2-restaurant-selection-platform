package com.srh.rsp.Restaurant;

import java.util.Scanner;

import com.srh.rsp.dbAccess.OfferCRUD;

import LogException.WriteExceptionToFile;

public class RestaurantOffers {
	WriteExceptionToFile log = new WriteExceptionToFile();
	
	public void addOffer() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Add Offers--------------");
		int choice = 1;
		try {
			Scanner input = new Scanner(System.in);
			do {
				newOffer();
				System.out.println("\n\nPress 0 to stop Offers or 1 to continue adding\n\n");
				choice = input.nextInt();
			} while(choice != 0);
		}catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void newOffer() {
		Scanner input = new Scanner(System.in);
		String offerDescription;
		float offerPercentage;
		try {
			System.out.print("Enter Offer %: ");
			offerPercentage = Float.parseFloat(input.nextLine());
			System.out.println("Enter Offer Description: ");
			offerDescription = input.nextLine();
			OfferCRUD offer = new OfferCRUD();
			offer.setNewOffer(UpdateRestaurant.restaurantID, CusineDishes.dishID, offerPercentage, offerDescription);
		} catch (NumberFormatException e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		} catch (Exception e) {
			System.out.println("\n**************Something went wrong.**************\n");
			log.appendToFile(e);
		}
	}
}
