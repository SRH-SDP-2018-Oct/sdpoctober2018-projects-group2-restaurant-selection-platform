package com.srh.rsp.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant_reservation")

public class RestaurantReservation {

	@Id
	@Column(name = "reservation_Id")
	private long reservationId;

	@Column(name = "restaurant_Id")
	private long restaurantId;

	@Column(name = "customer_Id")
	private long customerId;

	@Column(name = "number_of_people")
	private int NoOfPeople;

	@Column(name = "reservation_Status")
	private String reservationStatus;

	@Column(name = "booking_Date")
	private Date bookingDate;

	@Column(name = "from_Time")
	private Time fromTime;

	@Column(name = "to_Time")
	private Time toTime;

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public int getNoOfPeople() {
		return NoOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.NoOfPeople = noOfPeople;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public Time getFromTime() {
		return fromTime;
	}

	public void setFromTime(Time fromTime) {
		this.fromTime = fromTime;
	}

	public Time getToTime() {
		return toTime;
	}

	public void setToTime(Time toTime) {
		this.toTime = toTime;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	@Override
	public String toString() {
		return "RestaurantReservation [reservationId=" + reservationId + ", restaurantId=" + restaurantId
				+ ", customerId=" + customerId + ", NoOfPeople=" + NoOfPeople + ", reservationStatus="
				+ reservationStatus + ", bookingDate=" + bookingDate + ", fromTime=" + fromTime + ", toTime=" + toTime
				+ "]";
	}
}
