package com.km.vmcustomerordertraffic.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customerInfo")
public class CustomerInfo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "cust_seq")
	@Column(nullable = false, updatable = false, name = "custId")
	private int id;
	@Column(precision=10, scale=2)
	private float money;
	@Column(nullable = false, updatable = false)
	private String generateCode;
	private String status;
	private Date dateAdded;
	private Date dateUpdated;
	@OneToMany(cascade = CascadeType.ALL)//, orphanRemoval = true
	@JoinColumn(name="customer_id",referencedColumnName = "custId") 
	private List<CustomerOrder> orders;
	
	public CustomerInfo() {}

	public CustomerInfo(int id, float money, String generateCode, String status, Date dateAdded, Date dateUpdated,
			List<CustomerOrder> orders) {
		super();
		this.id = id;
		this.money = money;
		this.generateCode = generateCode;
		this.status = status;
		this.dateAdded = dateAdded;
		this.dateUpdated = dateUpdated;
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getGenerateCode() {
		return generateCode;
	}

	public void setGenerateCode(String generateCode) {
		this.generateCode = generateCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public List<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "CustomerInfo [id=" + id + ", money=" + money + ", generateCode=" + generateCode + ", status=" + status
				+ ", dateAdded=" + dateAdded + ", dateUpdated=" + dateUpdated + ", orders=" + orders + "]";
	}
}
