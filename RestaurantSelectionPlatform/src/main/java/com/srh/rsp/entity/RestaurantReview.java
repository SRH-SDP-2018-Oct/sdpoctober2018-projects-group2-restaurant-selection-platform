package com.srh.rsp.entity;

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
	private long reviewId;

	@Column(name = "restaurant_Id")
	private long restaurantId;

	@Column(name = "customer_Id")
	private long customerId;

	@Column(name = "rating")
	private float rating;

	@Column(name = "review_Text")
	private String reviewText;

	@Column(name = "time_Stamp")
	private Timestamp timeStamp;

	public long getReview_Id() {
		return reviewId;
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

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
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

	@Override
	public String toString() {
		return "RestaurantReview [reviewId=" + reviewId + ", restaurantId=" + restaurantId + ", customerId="
				+ customerId + ", rating=" + rating + ", reviewText=" + reviewText + ", timeStamp=" + timeStamp + "]";
	}

}
