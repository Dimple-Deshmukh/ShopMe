package org.piju.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class ShippingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shipId;
	
	@Column(length = 250)
	private String shipAddress;
	
	private long phoneNo;
	
	
	private int userId;
	
	
	private int orderId;
	
	

	public ShippingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShippingDetails(String shipAddress, long phoneNo, int userId, int orderId) {
		
		
		this.shipAddress = shipAddress;
		this.phoneNo = phoneNo;
		this.userId = userId;
		this.orderId = orderId;
	}

	public int getShipId() {
		return shipId;
	}

	public void setShipId(int shipId) {
		this.shipId = shipId;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
	
	
}
