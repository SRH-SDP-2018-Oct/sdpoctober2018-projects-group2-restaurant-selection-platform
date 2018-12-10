package com.srh.rsp;

import com.srh.rsp.dbAccess.CustomerAccountCRUD;
import com.srh.rsp.entity.CustomerLogin;

public class LoginSession {
	public static long userID;
	public static String userType;
	
	public void Login(String Email, String Password) {
		MainMenu loadMenu = new MainMenu();
		CustomerAccountCRUD loginSuccess = new CustomerAccountCRUD();
		CustomerLogin customerType = loginSuccess.fetchCustomerType(Email, Password);
		userID = customerType.getCustomerId();
		userType = customerType.getCustomerType();
		if (customerType.getCustomerType().equals("Both")) {
			loadMenu.DualUserMainMenu();
		}
		else if (customerType.getCustomerType().equals("Owner")) {
			loadMenu.OwnerMainMenu();
		}
		else if (customerType.getCustomerType().equals("User")) {
			loadMenu.CustomerMainMenu();
		}		
	}
}