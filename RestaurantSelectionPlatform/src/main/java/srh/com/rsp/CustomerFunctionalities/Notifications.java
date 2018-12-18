package srh.com.rsp.CustomerFunctionalities;

import java.util.List;
import java.util.Scanner;

import com.srh.rsp.LoginSession;
import com.srh.rsp.RestaurantDetailsSelect;
import com.srh.rsp.dbAccess.OfferCRUD;
import com.srh.rsp.dbAccess.RestaurantDetailsCRUD;
import com.srh.rsp.dbAccess.RestaurantReservationCRUD;
import com.srh.rsp.entity.OfferDetails;
import com.srh.rsp.entity.RestaurantDetails;
import com.srh.rsp.entity.RestaurantReservation;

import LogException.WriteExceptionToFile;

public class Notifications {
	// Customer should be notified about the new restaurants nearby
	// Customer should get the notification about the discounts from the restaurant
	String region;

	WriteExceptionToFile log = new WriteExceptionToFile();

	public void displayNotification() {
		if (LoginSession.userType.equals("User") || LoginSession.userType.equals("Both")) {
			System.out.println("Please choose a region:");
			RestaurantDetailsCRUD rDetailsCRUD = new RestaurantDetailsCRUD();
			List<String> regionList = rDetailsCRUD.fetchAllRestaurantRegion();
			for (int i = 0; i < regionList.size(); i++) {
				System.out.println(i + 1 + "." + regionList.get(i));
			}
			System.out.println("\nEnter Choice");
			Scanner input = new Scanner(System.in);
			try {
				region = regionList.get(Integer.parseInt(input.nextLine()) - 1);
				restaurantdetails(region);
				restaurantreservation();
			} catch (Exception e) {
				System.out.println("\n**************Please enter a valid input**************\n");
				log.appendToFile(e);
			}
		}
	}

	public void restaurantdetails(String region) {
		RestaurantDetailsCRUD rCrud = new RestaurantDetailsCRUD();
		List<RestaurantDetails> restaurntDetails = rCrud.fetchRestaurantDetailsOnRegion(region);

		for (int i = 0; i < restaurntDetails.size(); i++) {
			System.out.println("Restaurant Name: " + restaurntDetails.get(i).getRestaurantName());
			offerdetails(restaurntDetails.get(i).getRestaurantId());
		}
	}

	private void offerdetails(long restaurantID) {
		OfferCRUD detailOffer = new OfferCRUD();
		List<OfferDetails> offerdetails = detailOffer.offerdetailsonRestaurantId(restaurantID);
		for (int i = 0; i < offerdetails.size(); i++) {
			System.out.println("---------------------Offers available---------------------");
			System.out.println("Offer Description: " + offerdetails.get(i).getOfferDescription());
			System.out.println("Offer Percentage: " + offerdetails.get(i).getOfferPercentage());
		}
	}

	private void restaurantreservation() {
		RestaurantReservationCRUD rrc = new RestaurantReservationCRUD();
		List<RestaurantReservation> restaurantreservation = rrc.restaurantreservationonUserId(LoginSession.userID);
		for (int i = 0; i < restaurantreservation.size(); i++) {
			System.out.println("---------------------Reservation Details---------------------");
			System.out.println("Reservation from " + restaurantreservation.get(i).getFromTime() + "to " + restaurantreservation.get(i).getToTime());
			System.out.println("Booking Status: " + restaurantreservation.get(i).getReservationStatus());
		}
	}
}
