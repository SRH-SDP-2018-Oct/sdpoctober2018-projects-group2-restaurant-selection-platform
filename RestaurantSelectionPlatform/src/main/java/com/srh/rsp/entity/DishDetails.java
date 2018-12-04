package com.srh.rsp.entity;

import java.math.BigDecimal;
import java.util.Currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dish_details")

public class DishDetails {

	@Id
	@Column(name = "dish_Id")
	private long dishId;

	@Column(name = "dish_Name")
	private String dishName;

	@Column(name = "dish_Description")
	private String dishDescription;

	@Column(name = "dish_Type")
	private boolean dishType;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "currency_Unit")
	private Currency currency_Unit;

	@Column(name = "calories")
	private float calories;

	@Column(name = "picture")
	private String pictureLink;

	public long getDishId() {
		return dishId;
	}

	public void setDishId(long dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishDescription() {
		return dishDescription;
	}

	public void setDishDescription(String dishDescription) {
		this.dishDescription = dishDescription;
	}

	public boolean isDishType() {
		return dishType;
	}

	public void setDishType(boolean dishType) {
		this.dishType = dishType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Currency getCurrency_Unit() {
		return currency_Unit;
	}

	public void setCurrency_Unit(Currency currency_Unit) {
		this.currency_Unit = currency_Unit;
	}

	public float getCalories() {
		return calories;
	}

	public void setCalories(float calories) {
		this.calories = calories;
	}

	public String getPictureLink() {
		return pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	@Override
	public String toString() {
		return "Dish_Details [dishId=" + dishId + ", dishName=" + dishName + ", dishDescription=" + dishDescription
				+ ", dishType=" + dishType + ", price=" + price + ", currency_Unit=" + currency_Unit + ", calories="
				+ calories + ", pictureLink=" + pictureLink + "]";
	}

}
