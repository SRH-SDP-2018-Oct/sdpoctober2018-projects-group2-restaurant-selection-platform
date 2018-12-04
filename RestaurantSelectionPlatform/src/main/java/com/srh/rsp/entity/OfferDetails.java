package com.srh.rsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offer_details")

public class OfferDetails {

	@Id
	@Column(name = "offer_Id")
	private long offerId;

	@Column(name = "restaurant_Id")
	private long restaurantId;

	@Column(name = "offer_Percentage")
	private float offerPercentage;

	@Column(name = "offer_description")
	private String offerDescription;

	@Column(name = "dish_Id")
	private long dishId;

	public long getOfferId() {
		return offerId;
	}

	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public float getOfferPercentage() {
		return offerPercentage;
	}

	public void setOfferPercentage(float offerPercentage) {
		this.offerPercentage = offerPercentage;
	}

	public String getOfferDescription() {
		return offerDescription;
	}

	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}

	public long getDishId() {
		return dishId;
	}

	public void setDishId(long dishId) {
		this.dishId = dishId;
	}

	@Override
	public String toString() {
		return "OfferDetails [offerId=" + offerId + ", restaurantId=" + restaurantId + ", offerPercentage="
				+ offerPercentage + ", offerDescription=" + offerDescription + ", dishId=" + dishId + "]";
	}

}
