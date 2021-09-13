package com.km.vmcustomerordertraffic.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customerOrder")
public class CustomerOrder implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "corder_seq")
	@Column(nullable = false, updatable = false)
	private int id;
	private int productId;
	private int itemId;
//	@Column(nullable = true)
	private int customer_id;
	private Date dateAdded;
	
	public CustomerOrder() {}

	public CustomerOrder(int id, int productId, int itemId, int customer_id, Date dateAdded) {
		super();
		this.id = id;
		this.productId = productId;
		this.itemId = itemId;
		this.customer_id = customer_id;
		this.dateAdded = dateAdded;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public String toString() {
		return "CustomerOrder [id=" + id + ", productId=" + productId + ", itemId=" + itemId + ", customer_id="
				+ customer_id + ", dateAdded=" + dateAdded + "]";
	}

}
