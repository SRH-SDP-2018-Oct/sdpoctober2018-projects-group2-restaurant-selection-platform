package com.srh.rsp.dbAccess;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.EntityManager;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.RestaurantReview;

public class NewRestaurantReview {
	long restaurantid, customerid;
	String reviewtext;
	float raing;
	Timestamp timestamp;
	Date date;

	public void setRestaurantReview(long restaurantid, long customerid, String reviewtext, float rating,
			Timestamp timestamp, Date date) {
		RestaurantReview restaurantReview = new RestaurantReview();
		restaurantReview.setRestaurantId(restaurantid);
		restaurantReview.setCustomerId(customerid);
		restaurantReview.setReviewText(reviewtext);
		restaurantReview.setTimeStamp(timestamp);
		restaurantReview.setDate(date);

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(restaurantReview);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
	}
}
