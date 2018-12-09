package com.srh.rsp.dbAccess;

import javax.persistence.EntityManager;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.OfferDetails;
//
public class OfferCRUD {
	long restaurantid, dishid;
	float offerpercentage;
	String offerdescription;

	public void setNewOffer(long restaurantid, long dishid, float offerpercentage, String offerdescription) {

		OfferDetails offerDetails = new OfferDetails();
		offerDetails.setDishId(dishid);
		offerDetails.setOfferDescription(offerdescription);
		offerDetails.setOfferPercentage(offerpercentage);
		offerDetails.setRestaurantId(restaurantid);

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(offerDetails);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();

	}

}
