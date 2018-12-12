package srh.com.rsp.CustomerFunctionalities;

import java.util.List;
import java.util.Scanner;

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

	public void displayNotification(String customertype, long restaurantid) {
		if (customertype == "User" || customertype == "Both") {
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
				input.close();
			}

			catch (Exception e) {
				System.out.println("\n**************Please enter a valid input**************\n");
				log.appendToFile(e);
			}

		}
	}

	public void restaurantdetails(String region) {

		RestaurantDetailsCRUD rCrud = new RestaurantDetailsCRUD();
		List<RestaurantDetails> restaurntDetails = rCrud.fetchRestaurantDetailsOnRegion(region);

		for (int i = 0; i < restaurntDetails.size(); i++) {

			System.out.println((i + 1 + "." + restaurntDetails.get(i).getRestaurantId()
					+ restaurntDetails.get(i).getRestaurantName()));
			System.out.println("restaurant name");
			System.out.println("restaurantid");

			offerdetails(restaurntDetails.get(i).getRestaurantId());
		}
	}

	private void offerdetails(Long restaurantid) {

		OfferCRUD oc = new OfferCRUD();
		List<OfferDetails> offerdetails = oc.offerdetailsonRestaurantId(restaurantid);
		for (int i = 0; i < offerdetails.size(); i++) {

			System.out.println(offerdetails.get(i).getOfferId() + offerdetails.get(i).getOfferDescription()
					+ offerdetails.get(i).getOfferPercentage());
			System.out.println("offer id");
			System.out.println("offer percentage");
			System.out.println("offer description");
		}
	}

	private void restaurantreservation(long userId) 
	{
		RestaurantReservationCRUD rrc = new RestaurantReservationCRUD();
		List<RestaurantReservation> restaurantreservation = rrc.restaurantreservationonUserId(userId);
		for (int i = 0; i < restaurantreservation.size(); i++) {
			System.out.println(restaurantreservation.get(i).getReservationId()+restaurantreservation.get(i).getReservationStatus()+restaurantreservation.get(i).getBookingDate()+restaurantreservation.get(i).getFromTime()+restaurantreservation.get(i).getToTime());
			System.out.println("Reservationid");
			System.out.println("ReservationStautus");
			System.out.println("BookingStatus");
			System.out.println("FromTime");
			System.out.println("ToTime");
		}
	}
}
