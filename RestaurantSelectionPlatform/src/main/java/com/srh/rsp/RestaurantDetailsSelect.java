package com.srh.rsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.srh.rsp.dbAccess.DishCRUD;
import com.srh.rsp.dbAccess.RestaurantDetailsCRUD;
import com.srh.rsp.dbAccess.RestaurantDishCRUD;
import com.srh.rsp.dbAccess.RestaurantReviewCRUD;
import com.srh.rsp.entity.DishDetails;
import com.srh.rsp.entity.RestaurantDetails;
import com.srh.rsp.entity.RestaurantDish;
import com.srh.rsp.entity.RestaurantReview;

import LogException.WriteExceptionToFile;
import srh.com.rsp.CustomerFunctionalities.CustomerReview;
import srh.com.rsp.CustomerFunctionalities.TableReservation;

public class RestaurantDetailsSelect {
	public static long restaurantID;
	WriteExceptionToFile log = new WriteExceptionToFile();
	
	public void displayRestaurantDetails(Long restaurantid, Long userid) {
		RestaurantDetailsCRUD rDetailsCRUD = new RestaurantDetailsCRUD();
		RestaurantDishCRUD rDishCRUD = new RestaurantDishCRUD();
		RestaurantReviewCRUD rReviewCRUD = new RestaurantReviewCRUD();
		DishCRUD dishCRUD = new DishCRUD();
		RestaurantDetails rDetails = rDetailsCRUD.listOfRestaurantDetailsOnRestaurantId(restaurantid);
		List<RestaurantDish> listRDish = rDishCRUD.listOfRestaurantDishOnRestaurantId(restaurantid);
		List<DishDetails> listOfDishDetails = new ArrayList<DishDetails>();

		listRDish.forEach(dishId -> {
			DishDetails dishDetail = dishCRUD.dishDetailsOnId(dishId.getDishId());
			if (dishDetail != null) {
				listOfDishDetails.add(dishDetail);
			}
		});
		restaurantID = restaurantid;
		
		List<RestaurantReview> rReview = rReviewCRUD.getRestaurantReviewsOnRestaurantId(restaurantid);

		double averageRating = 0;

		if (rReview != null) {
			for (int i = 0; i < rReview.size(); i++) {
				averageRating += rReview.get(i).getRating();
				averageRating = (averageRating / rReview.size());
			}
		}

		System.out.println("..........." + rDetails.getRestaurantName() + "...........");
		System.out.println("\n");
		System.out.println("Contact Details:");
		System.out.println("Email ID- " + rDetails.getEmailId());
		System.out.println("Phone Number- - " + "+" + rDetails.getCountryKey() + " " + rDetails.getPhoneNumber());
		System.out.println("\nAverage rating : " + averageRating);
		System.out.println("\nAddress:");
		System.out.println("House Number & Street- " + rDetails.getHousenumberStreet());
		System.out.println("City- " + rDetails.getCity());
		System.out.println("Region- " + rDetails.getRegion());
		System.out.println("Postal Code- " + rDetails.getPostalCode());
		System.out.println("\nAdditional details :");

		boolean vegFlag = rDetails.isVegNon();
		boolean partyFlag = rDetails.isVegNon();
		boolean petsFlag = rDetails.isVegNon();
		if (vegFlag = true)
			System.out.println("Non Vegetarian restaurant ");
		else
			System.out.println("Vegetarian restaurant ");
		if (partyFlag = true)
			System.out.println("Party space available");
		else
			System.out.println("Party space not available ");
		if (petsFlag = true)
			System.out.println("Pets allowed");
		else
			System.out.println("Pets not allowed ");

		System.out.println("\nDishes available :");

		for (int i = 0; i < listOfDishDetails.size(); i++) {
			System.out.println(i + 1 + ". " + listOfDishDetails.get(i).getDishName() + "\n"
					+ listOfDishDetails.get(i).getDishDescription() + '\n' + listOfDishDetails.get(i).getPrice() + " "
					+ listOfDishDetails.get(i).getCurrency_Unit() + "\n" + listOfDishDetails.get(i).getCalories()
					+ " Calories");
			if (listOfDishDetails.get(i).isDishType() == false)
				System.out.println("Veg");
			else
				System.out.println("Non Veg");
		}

		System.out.println("\n****************************************************** ");
		System.out.println("Select an option:");
		System.out.println("1.Make a reservation \n2.Give review \n3.Go back to search \n0. Back to Mail Menu");
		System.out.print("Enter Choice: ");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			if (choice == 1) {
				TableReservation request = new TableReservation();
				request.reservationRequest();
			} else if (choice == 2) {
				CustomerReview review = new CustomerReview();
				review.giveRating();
			} else if (choice == 3) {
				SearchFunction sf = new SearchFunction();
				sf.searchInput(userid);
			} else {
				LoginSession.loadMenu();
			}

		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}

	}
}
