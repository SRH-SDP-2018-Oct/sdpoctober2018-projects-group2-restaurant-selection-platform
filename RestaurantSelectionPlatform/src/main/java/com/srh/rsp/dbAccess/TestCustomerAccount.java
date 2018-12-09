package com.srh.rsp.dbAccess;

public class TestCustomerAccount {

	String username = "Sree", password = "Aa1Bb2#", email = "sreehari@gmail.com", customertype = "Both";
	long phonenumber = 9791154557L;

	public void testCustomerAccount() {

		NewCustomerAccount createCustomer = new NewCustomerAccount();
		createCustomer.setCustomerAccount(username, password, email, customertype, phonenumber);
	}
}