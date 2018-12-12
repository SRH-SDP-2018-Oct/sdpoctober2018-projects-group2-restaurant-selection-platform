package com.srh.rsp.dbAccess;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.RestaurantReservation;

public class RestaurantReservationCRUD {
	long restaurantid, customerid;
	int noOfPeople;
	boolean reservaionstaus;
	Date bookingdate;
	Time fromtime;
	Time totime;
	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
	CriteriaBuilder cbuilder = PersistenceManager.INSTANCE.getCriteriaBuilder();

	public void setRestaurantReservation(long restaurantid, long customerid, int noOfPeople, String reservationstatus,
			Date bookingdate, Time fromtime, Time totime) {
		RestaurantReservation restaurantReservaion = new RestaurantReservation();
		restaurantReservaion.setRestaurantId(restaurantid);
		restaurantReservaion.setCustomerId(customerid);
		restaurantReservaion.setNoOfPeople(noOfPeople);
		restaurantReservaion.setReservationStatus(reservationstatus);
		restaurantReservaion.setBookingDate(bookingdate);
		restaurantReservaion.setFromTime(fromtime);
		restaurantReservaion.setToTime(totime);

		em.getTransaction().begin();
		em.persist(restaurantReservaion);
		em.getTransaction().commit();
	}

	public List<RestaurantReservation> getRestaurantReservation(long restaurantid) {
		CriteriaQuery<RestaurantReservation> criteriaQuery = cbuilder.createQuery(RestaurantReservation.class);
		Root<RestaurantReservation> reservationDetailsRoot = criteriaQuery.from(RestaurantReservation.class);
		criteriaQuery.select(reservationDetailsRoot);
		criteriaQuery.where(cbuilder.equal(reservationDetailsRoot.get("restaurantId"), restaurantid),
				cbuilder.equal(reservationDetailsRoot.get("reservationStatus"), "Processing"));
		List<RestaurantReservation> restaurantDetails = em.createQuery(criteriaQuery).getResultList();
		if (restaurantDetails.isEmpty()) {
			// list is empty
			return null;
		}
		return restaurantDetails;
	}

	public void setReservationStatus(String status, RestaurantReservation data) {
		RestaurantReservation detail = em.find(RestaurantReservation.class, data.getReservationId());
		em.getTransaction().begin();
		detail.setReservationStatus(status);
		em.getTransaction().commit();
		System.out.println("Request Status updated " + status);
	}
	
	public List<RestaurantReservation> restaurantreservationonUserId(long userID){
		CriteriaQuery<RestaurantReservation> criteriaQuery = cbuilder.createQuery(RestaurantReservation.class);
		Root<RestaurantReservation> reservationDetailsRoot = criteriaQuery.from(RestaurantReservation.class);
		criteriaQuery.select(reservationDetailsRoot);
		criteriaQuery.where(cbuilder.equal(reservationDetailsRoot.get("userID"), userID));
		List<RestaurantReservation> restaurantDetails = em.createQuery(criteriaQuery).getResultList();
		if (restaurantDetails.isEmpty()) {
			// list is empty
			return null;
		}
		return restaurantDetails;
	}

}
