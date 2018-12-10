package com.srh.rsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_login")
public class CustomerLogin {
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	@Id
	@Column(name = "customer_Id")
	private long customerId;

	@Column(name = "user_Name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "customer_Type")
	private String customerType;

	@Column(name = "email_Id")
	private String emailId;

	@Column(name = "phone_Number")
	private String phoneNumber;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getCustomerId() {
		return customerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

}
