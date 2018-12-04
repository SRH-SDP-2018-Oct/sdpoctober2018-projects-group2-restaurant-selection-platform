package com.srh.rsp.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant_review")
public class RestaurantReview {

	@Id
	@Column(name = "review_Id")
	private long review_Id;

	@Column(name = "restaurant_Id")
	private long restaurant_Id;

	@Column(name = "customer_Id")
	private String customer_Id;

	@Column(name = "rating")
	private float rating;

	@Column(name = "review_Text")
	private String reviewText;

	@Column(name = "time_Stamp")
	private Timestamp timeStamp;

	@Column(name = "date")
	private Date date;

	public long getReview_Id() {
		return review_Id;
	}

	public void setReview_Id(long review_Id) {
		this.review_Id = review_Id;
	}

	public long getRestaurant_Id() {
		return restaurant_Id;
	}

	public void setRestaurant_Id(long restaurant_Id) {
		this.restaurant_Id = restaurant_Id;
	}

	public String getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(String customer_Id) {
		this.customer_Id = customer_Id;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Restaurant_Review [review_Id=" + review_Id + ", restaurant_Id=" + restaurant_Id + ", customer_Id="
				+ customer_Id + ", rating=" + rating + ", reviewText=" + reviewText + ", timeStamp=" + timeStamp
				+ ", date=" + date + "]";
	}

	
}
