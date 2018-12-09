package com.srh.rsp.dbAccess;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.EntityManager;

import com.srh.rsp.PersistenceManager;
import com.srh.rsp.entity.RestaurantReservation;

public class NewRestaurantReservation {
	long restaurantid, customerid;
	String seatid;
	boolean reservaionstaus;
	Date bookingdate;
	Time fromtime;
	Time totime;

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

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(restaurantReservaion);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();

	}

}
