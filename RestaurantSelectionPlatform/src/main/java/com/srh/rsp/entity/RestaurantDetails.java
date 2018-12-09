package com.srh.rsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant_details")
public class RestaurantDetails {

	@Id
	@Column(name = "restaurant_Id")
	private long restaurantId;

	@Column(name = "restaurant_Name")
	private String restaurantName;

	@Column(name = "line_Item")
	private int lineItem;

	@Column(name = "customer_Id")
	private long customerId;

	@Column(name = "email_Id")
	private String emailId;

	@Column(name = "phone_Number")
	private long phoneNumber;

	@Column(name = "country_Key")
	private int countryKey;

	@Column(name = "city")
	private String city;

	@Column(name = "postal_Code")
	private int postalCode;

	@Column(name = "region")
	private String region;

	@Column(name = "housenumber_Street")
	private String housenumberStreet;

	@Column(name = "veg_Non")
	private boolean vegNon;

	@Column(name = "party_Space")
	private boolean partySpace;

	@Column(name = "pets_Allowed")
	private boolean petsAllowed;

	@Column(name = "picture_Link")
	private String pictureLink;

	@Column(name = "subscription_Status")
	private int subscriptionStatus;

	public long getRestaurantId() {
		return restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getLineItem() {
		return lineItem;
	}

	public void setLineItem(int lineItem) {
		this.lineItem = lineItem;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getCountryKey() {
		return countryKey;
	}

	public void setCountryKey(int countryKey) {
		this.countryKey = countryKey;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getHousenumberStreet() {
		return housenumberStreet;
	}

	public void setHousenumberStreet(String housenumberStreet) {
		this.housenumberStreet = housenumberStreet;
	}

	public boolean isVegNon() {
		return vegNon;
	}

	public void setVegNon(boolean vegNon) {
		this.vegNon = vegNon;
	}

	public boolean isPartySpace() {
		return partySpace;
	}

	public void setPartySpace(boolean partySpace) {
		this.partySpace = partySpace;
	}

	public boolean isPetsAllowed() {
		return petsAllowed;
	}

	public void setPetsAllowed(boolean petsAllowed) {
		this.petsAllowed = petsAllowed;
	}

	public String getPictureLink() {
		return pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	public int getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(int subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

	@Override
	public String toString() {
		return "RestaurantDetails [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", lineItem="
				+ lineItem + ", customerId=" + customerId + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber
				+ ", countryKey=" + countryKey + ", city=" + city + ", postalCode=" + postalCode + ", region=" + region
				+ ", housenumberStreet=" + housenumberStreet + ", vegNon=" + vegNon + ", partySpace=" + partySpace
				+ ", petsAllowed=" + petsAllowed + ", pictureLink=" + pictureLink + ", subscriptionStatus="
				+ subscriptionStatus + ", getRestaurantId()=" + getRestaurantId() + ", getRestaurantName()="
				+ getRestaurantName() + ", getLineItem()=" + getLineItem() + ", getCustomerId()=" + getCustomerId()
				+ ", getEmailId()=" + getEmailId() + ", getPhoneNumber()=" + getPhoneNumber() + ", getCountryKey()="
				+ getCountryKey() + ", getCity()=" + getCity() + ", getPostalCode()=" + getPostalCode()
				+ ", getRegion()=" + getRegion() + ", getHousenumberStreet()=" + getHousenumberStreet()
				+ ", isVegNon()=" + isVegNon() + ", isPartySpace()=" + isPartySpace() + ", isPetsAllowed()="
				+ isPetsAllowed() + ", getPictureLink()=" + getPictureLink() + ", getSubscriptionStatus()="
				+ getSubscriptionStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
