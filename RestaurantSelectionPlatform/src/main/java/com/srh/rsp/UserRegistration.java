package com.srh.rsp;

import com.srh.rsp.dbAccess.CustomerAccountCRUD;

public class UserRegistration {
	public void NewRegistration(RegistrationData userDetails, int userRole) {
		String role = null;
		if (userRole == 1)
			role = "User";
		else if (userRole == 2)
			role = "Owner";
		else if (userRole == 3)
			role = "Both";
		CustomerAccountCRUD newUser = new CustomerAccountCRUD();
		newUser.setCustomerAccount(userDetails.personName, userDetails.passWord, userDetails.eMail, role, userDetails.contactNumber);
		
		LoginHome mainPage = new LoginHome();
		mainPage.afterRegistration();
	}
}