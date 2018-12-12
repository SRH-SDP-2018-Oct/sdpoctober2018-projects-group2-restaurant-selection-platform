package com.srh.rsp;

import com.srh.rsp.dbAccess.CustomerAccountCRUD;
import com.srh.rsp.entity.CustomerLogin;

public class LoginSession {
	public static long userID;
	public static String userType;
	
	public void Login(String Email, String Password) {
		CustomerAccountCRUD loginSuccess = new CustomerAccountCRUD();
		CustomerLogin customerType = loginSuccess.fetchCustomerType(Email, Password);
		userID = customerType.getCustomerId();
		userType = customerType.getCustomerType();
		loadMenu();
	}
	
	public static void loadMenu() {
		MainMenu loadMenu = new MainMenu();
		if (userType.equals("Both")) {
			loadMenu.DualUserMainMenu();
		} else if (userType.equals("Owner")) {
			loadMenu.OwnerMainMenu();
		} else if (userType.equals("User")) {
			loadMenu.CustomerMainMenu();
		}
	}
}