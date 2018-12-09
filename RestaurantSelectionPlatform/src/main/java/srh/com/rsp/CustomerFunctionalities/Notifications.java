package srh.com.rsp.CustomerFunctionalities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

import android.database.SQLException;

public class Notifications {
	// Customer should be notified about the restaurants nearby
	// Customer should get the notification about the discounts from the restaurant

	public void entry() {
		List listStrings = (List) new ArrayList<String>();
		System.out.println(listStrings);
		OfferDetails("Heidelberg");
	}

	protected void OfferDetails(String location) {
		List listStrings = (List) new ArrayList<String>();
		listStrings.add("Raja Rani");
		listStrings.add("Saffron");
		listStrings.add("Punjab Curry");
		System.out.println(listStrings);
	}
}

class Restaurant {
	private final String DBConnection = null;

	public ArrayList<Restaurant> getRestaurant() throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getDBConnection().getConnection();
		Statement stm;
		stm = (Statement) conn.createStatement();
		String sql = "Select * From Restaurant";
		ResultSet rst;
		rst = ((java.sql.Statement) stm).executeQuery(sql);
		ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
		while (rst.next()) {
			Restaurant restaurant = new Restaurant();
			restaurantList.add(restaurant);
		}
		return restaurantList;
	}

	protected void OfferDescription(String location) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please select the restaurant");
		OfferPercentage("Heidelberg");
	}

	protected void OfferPercentage(String location) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please select the restaurant");
		int type = input.nextInt();
		System.out.println(type);
	}

}
