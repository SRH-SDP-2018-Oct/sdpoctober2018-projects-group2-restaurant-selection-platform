package com.srh.rsp.dbAccess;

import javax.persistence.EntityManager;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.RestaurantDetails;

import LogException.WriteExceptionToFile;

public class RestaurantDetailsCRUD {
	WriteExceptionToFile log = new WriteExceptionToFile();
	String restaurantname, emailid, city, region, housenumberstreet, picturelink;
	int countrykey, postalcode, subscriptionstatus;
	boolean petsallowed, partyspace, vegnon;
	long phonenumber, customerid;
	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

	public void setRestaurantDetails(String restaurantname, String emailid, String city, String region,
			String housenumberstreet, String picturelink, long customerid, int countrykey, int postalcode,
			boolean petsallowed, boolean partyspace, boolean vegnon, String phonenumber) {

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

		em.getTransaction().begin();
		em.persist(restaurantDetails);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
	}
}
