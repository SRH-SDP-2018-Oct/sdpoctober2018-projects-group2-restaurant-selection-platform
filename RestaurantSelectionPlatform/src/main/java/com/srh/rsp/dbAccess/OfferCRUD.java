package com.srh.rsp.dbAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.OfferDetails;

//
public class OfferCRUD {
	long restaurantid, dishid;
	float offerpercentage;
	String offerdescription;
	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
	CriteriaBuilder cbuilder = PersistenceManager.INSTANCE.getCriteriaBuilder();

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
	}

	public List<OfferDetails> offerdetailsonRestaurantId(Long restaurantid) {
		CriteriaQuery<OfferDetails> criteriaQuery = cbuilder.createQuery(OfferDetails.class);
		Root<OfferDetails> offerdetailsRoot = criteriaQuery.from(OfferDetails.class);
		criteriaQuery.select(offerdetailsRoot);
		criteriaQuery.where(cbuilder.equal(offerdetailsRoot.get("RestaurantId"), restaurantid));
		List<OfferDetails> listofofferdetailsDetails = em.createQuery(criteriaQuery).getResultList();
		if (listofofferdetailsDetails.isEmpty()) {
			// list is empty
			return null;
		}
		return listofofferdetailsDetails;

	}
}
