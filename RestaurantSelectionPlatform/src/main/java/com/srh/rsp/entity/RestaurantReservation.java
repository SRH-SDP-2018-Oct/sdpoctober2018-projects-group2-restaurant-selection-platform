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

	@Column(name = "seat_Id")
	private String seatId;

	@Column(name = "reservation_Status")
	private boolean reservationStatus;

	@Column(name = "booking_Date")
	private Date booking_Date;

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

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public boolean isReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(boolean reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public Date getBooking_Date() {
		return booking_Date;
	}

	public void setBooking_Date(Date booking_Date) {
		this.booking_Date = booking_Date;
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

	@Override
	public String toString() {
		return "RestaurantReservation [reservationId=" + reservationId + ", restaurantId=" + restaurantId
				+ ", customerId=" + customerId + ", seatId=" + seatId + ", reservationStatus=" + reservationStatus
				+ ", booking_Date=" + booking_Date + ", fromTime=" + fromTime + ", toTime=" + toTime + "]";
	}

}
