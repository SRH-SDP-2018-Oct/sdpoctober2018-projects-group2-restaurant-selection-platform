package com.srh.rsp.setEntity;

import javax.persistence.EntityManager;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.RestaurantDetails;

public class NewRestaurantDetails {
	String restaurantname, emailid, city, region, housenumberstreet, picturelink;
	int countrykey, postalcode, subscriptionstatus;
	boolean petsallowed, partyspace, vegnon;
	long phonenumber,customerid;

	public void setRestaurantDetails(String restaurantname, String emailid, String city, String region,
			String housenumberstreet, String picturelink, long customerid, int countrykey, int postalcode,
			int subscriptionstatus, boolean petsallowed, boolean partyspace, boolean vegnon, long phonenumber) {

		RestaurantDetails restaurantDetails = new RestaurantDetails();
		restaurantDetails.setRestaurantName(restaurantname);
		restaurantDetails.setEmailId(emailid);
		restaurantDetails.setCity(city);
		restaurantDetails.setRegion(region);
		restaurantDetails.setHousenumberStreet(housenumberstreet);
		restaurantDetails.setPictureLink(picturelink);
		restaurantDetails.setCustomerId(customerid);
		restaurantDetails.setCountryKey(countrykey);
		restaurantDetails.setPostalCode(postalcode);
		restaurantDetails.setSubscriptionStatus(subscriptionstatus);
		restaurantDetails.setPetsAllowed(petsallowed);
		restaurantDetails.setVegNon(vegnon);
		restaurantDetails.setPhoneNumber(phonenumber);

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(restaurantDetails);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();

	}
}
