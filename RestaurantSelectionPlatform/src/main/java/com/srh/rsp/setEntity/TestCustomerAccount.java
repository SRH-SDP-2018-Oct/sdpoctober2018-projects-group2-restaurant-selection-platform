package com.srh.rsp.setEntity;

public class TestCustomerAccount {

	String username = "Sreehari", password = "Aa1Bb2CC3DD4#", email = "sreehari.sm@gmail.com", customertype = "Both";
	long phonenumber = 9791154550L;

	public void testCustomerAccount() {

		NewCustomerAccount createCustomer = new NewCustomerAccount();
		createCustomer.setCustomerAccount(username, password, email, customertype, phonenumber);
	}
}