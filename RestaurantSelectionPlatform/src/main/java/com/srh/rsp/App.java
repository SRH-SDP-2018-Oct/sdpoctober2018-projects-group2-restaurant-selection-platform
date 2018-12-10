package com.srh.rsp;

<<<<<<< HEAD
=======
import com.srh.rsp.dbAccess.RestaurantDetailsCRUD;

>>>>>>> d87f525... SearchFunction
public class App {

	public static void main(String[] args) {

		// LoginHome mainPage = new LoginHome();
		// mainPage.ConsoleMenu();

		RestaurantDetailsCRUD rdCRUD = new RestaurantDetailsCRUD();
		rdCRUD.setRestaurantDetails("Lalit Ashok", "Lalit.Ashok@gmail.com", "Heidelberg", "BismarkPlatz", "45", "linkf",
				1L, 49, 678954, true, true, true, "9791154550");
	}
}