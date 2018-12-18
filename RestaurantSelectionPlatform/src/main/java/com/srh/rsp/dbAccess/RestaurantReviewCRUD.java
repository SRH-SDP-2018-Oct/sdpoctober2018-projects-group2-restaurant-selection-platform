package com.srh.rsp.dbAccess;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.RestaurantReview;

public class RestaurantReviewCRUD {
	long restaurantid, customerid;
	String reviewtext;
	float raing;
	Timestamp timestamp;

	CriteriaBuilder cbuilder = PersistenceManager.INSTANCE.getCriteriaBuilder();
	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

	public void setRestaurantReview(long restaurantid, long customerid, String reviewtext, float rating,
			Timestamp timestamp) {
		RestaurantReview restaurantReview = new RestaurantReview();
		restaurantReview.setRestaurantId(restaurantid);
		restaurantReview.setCustomerId(customerid);
		restaurantReview.setReviewText(reviewtext);
		restaurantReview.setTimeStamp(timestamp);

		em.getTransaction().begin();
		em.persist(restaurantReview);
		em.getTransaction().commit();
		em.close();
	}

	public List<RestaurantReview> getRestaurantReviewsOnRestaurantId(Long restaurantid) {

		CriteriaQuery<RestaurantReview> criteriaQuery = cbuilder.createQuery(RestaurantReview.class);
		Root<RestaurantReview> restaurantReviewRoot = criteriaQuery.from(RestaurantReview.class);
		criteriaQuery.select(restaurantReviewRoot);
		criteriaQuery.where(cbuilder.equal(restaurantReviewRoot.get("restaurantId"), restaurantid));
		List<RestaurantReview> rReviewDetails = em.createQuery(criteriaQuery).getResultList();
		if (rReviewDetails.isEmpty()) {
			// list is empty
			return null;
		}
		em.close();
		return rReviewDetails;
	}
}
