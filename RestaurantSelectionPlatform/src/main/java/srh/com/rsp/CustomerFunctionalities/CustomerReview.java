package srh.com.rsp.CustomerFunctionalities;

import java.sql.Timestamp;
import java.util.Scanner;

import com.srh.rsp.LoginSession;
import com.srh.rsp.RestaurantDetailsSelect;
import com.srh.rsp.dbAccess.RestaurantReviewCRUD;

import LogException.WriteExceptionToFile;

public class CustomerReview {
	WriteExceptionToFile log = new WriteExceptionToFile();
	
	public void giveRating() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please rate our restaurant");
		System.out.println("\n1. Poor \n2. Average \n3. Good \n4. Very good \n5. Excellent");
		System.out.println("Press 0 to Exit to Main Menu");
		System.out.println("Enter your choice");
		try {
			float rating = Float.parseFloat(input.nextLine());
			if (rating != 0)
				giveFeedback(rating);
			else
				LoginSession.loadMenu();
		} catch (NumberFormatException e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void giveFeedback(float rating) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please provide your feedback");
		String review = input.nextLine();
		
		// DB call to enter rating & review
		RestaurantReviewCRUD newReview = new RestaurantReviewCRUD();
		newReview.setRestaurantReview(RestaurantDetailsSelect.restaurantID, LoginSession.userID, review, rating, new Timestamp(System.currentTimeMillis()), null);
		System.out.println("Thank you for your feedback ");
		LoginSession.loadMenu();
	}
}
