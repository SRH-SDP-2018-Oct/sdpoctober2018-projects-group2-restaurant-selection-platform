package com.srh.rsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant_cuisine")

public class RestaurantCusine {

	@Id
	@Column(name = "iD")
	private long iD;

	@Column(name = "restaurant_Id")
	private long restaurantId;

	@Column(name = "cusine_Id")
	private long cusineId;

	@Column(name = "restaurant_Name")
	private String restaurantName;

	@Column(name = "cuisine_Name")
	private String cuisineName;

	public long getiD() {
		return iD;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public long getCusineId() {
		return cusineId;
	}

	public void setCusineId(long cusineId) {
		this.cusineId = cusineId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getCuisineName() {
		return cuisineName;
	}

	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}

	@Override
	public String toString() {
		return "RestaurantCusine [iD=" + iD + ", restaurantId=" + restaurantId + ", cusineId=" + cusineId
				+ ", restaurantName=" + restaurantName + ", cuisineName=" + cuisineName + "]";
	}

}
