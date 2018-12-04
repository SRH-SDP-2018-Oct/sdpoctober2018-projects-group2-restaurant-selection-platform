package com.srh.rsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cuisine_type")

public class CusineType {

	@Id
	@Column(name = "cuisine_Id")
	private long cuisineId;

	@Column(name = "cuisine_Name")
	private String cusineName;

	@Column(name = "cusine_Description")
	private String cusine_Description;

	public long getCuisineId() {
		return cuisineId;
	}

	public void setCuisineId(long cuisineId) {
		this.cuisineId = cuisineId;
	}

	public String getCusineName() {
		return cusineName;
	}

	public void setCusineName(String cusineName) {
		this.cusineName = cusineName;
	}

	public String getCusine_Description() {
		return cusine_Description;
	}

	public void setCusine_Description(String cusine_Description) {
		this.cusine_Description = cusine_Description;
	}

	@Override
	public String toString() {
		return "CusineType [cuisineId=" + cuisineId + ", cusineName=" + cusineName + ", cusine_Description="
				+ cusine_Description + "]";
	}

}
