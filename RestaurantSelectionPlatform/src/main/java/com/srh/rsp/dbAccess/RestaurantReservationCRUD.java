package com.srh.rsp.dbAccess;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.RestaurantReservation;

public class RestaurantReservationCRUD {
	long restaurantid, customerid;
	String seatid;
	boolean reservaionstaus;
	Date bookingdate;
	Time fromtime;
	Time totime;
	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
	CriteriaBuilder cbuilder = PersistenceManager.INSTANCE.getCriteriaBuilder();

	public void setRestaurantReservation(long restaurantid, long customerid, String seatid, boolean reservationstatus,
			Date bookingdate, Time fromtime, Time totime) {
		RestaurantReservation restaurantReservaion = new RestaurantReservation();
		restaurantReservaion.setRestaurantId(restaurantid);
		restaurantReservaion.setCustomerId(customerid);
		restaurantReservaion.setSeatId(seatid);
		restaurantReservaion.setReservationStatus(reservationstatus);
		restaurantReservaion.setBookingDate(bookingdate);
		restaurantReservaion.setFromTime(fromtime);
		restaurantReservaion.setToTime(totime);

		em.getTransaction().begin();
		em.persist(restaurantReservaion);
		em.getTransaction().commit();
		em.close();
	}

}
