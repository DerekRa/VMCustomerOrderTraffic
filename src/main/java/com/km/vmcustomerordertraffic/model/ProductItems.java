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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Details about Product Item List Model")
public class ProductItems implements Serializable {
	
	@ApiModelProperty(position = 0, notes = "Unique id and auto generate with hybernate of Config List")
	private int id;
	@ApiModelProperty(position = 1, notes = "Name of the item")
	private String name;
	@ApiModelProperty(position = 2, notes = "Amount or Quantity of the item")
	private int amount;
	@ApiModelProperty(position = 3, notes = "Price of the item")
	private String price;
	@ApiModelProperty(position = 4, notes = "Category Id that is mappped on Product Model")
	private int product_id;
	private Date dateAdded;
	
	public ProductItems() {}

	public ProductItems(int id, String name, int amount, String price, int product_id, Date dateAdded) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.product_id = product_id;
		this.dateAdded = dateAdded;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public String toString() {
		return "ProductItems [id=" + id + ", name=" + name + ", amount=" + amount + ", price=" + price + ", product_id="
				+ product_id + ", dateAdded=" + dateAdded + "]";
	}

	
}
