package com.srh.rsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant_dish")

public class RestaurantDish {

	@Id
	@Column(name = "iD")
	private long iD;

	@Column(name = "restaurant_Id")
	private long restaurant_Id;

	@Column(name = "dish_Id")
	private long dishId;

	@Column(name = "restaurant_Name")
	private String restaurantName;

	@Column(name = "dish_Name")
	private String dishName;

	public long getiD() {
		return iD;
	}

	public void setiD(long iD) {
		this.iD = iD;
	}

	public long getRestaurant_Id() {
		return restaurant_Id;
	}

	public void setRestaurant_Id(long restaurant_Id) {
		this.restaurant_Id = restaurant_Id;
	}

	public long getDishId() {
		return dishId;
	}

	public void setDishId(long dishId) {
		this.dishId = dishId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	@Override
	public String toString() {
		return "Restaurant_Dish [iD=" + iD + ", restaurant_Id=" + restaurant_Id + ", dishId=" + dishId
				+ ", restaurantName=" + restaurantName + ", dishName=" + dishName + "]";
	}

}
