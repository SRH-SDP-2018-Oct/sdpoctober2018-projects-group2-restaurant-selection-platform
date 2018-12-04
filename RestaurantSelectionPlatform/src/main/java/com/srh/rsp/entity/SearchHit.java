package com.srh.rsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "search_hit")
public class SearchHit {

	
	@Id
	@Column(name = "item_Id")
	private long itemId;
	
	@Column(name = "hits")	
	private long hits;
	
	@Column(name = "rd_flag")
	private boolean rdFlag;

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getHits() {
		return hits;
	}

	public void setHits(long hits) {
		this.hits = hits;
	}

	public boolean isRdFlag() {
		return rdFlag;
	}

	public void setRdFlag(boolean rdFlag) {
		this.rdFlag = rdFlag;
	}

	@Override
	public String toString() {
		return "SearchHit [itemId=" + itemId + ", hits=" + hits + ", rdFlag=" + rdFlag + "]";
	}
	
	
}
