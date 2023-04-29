package org.piju.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@Column(length = 250)
	private String cartProdName;
	@Column(length = 250)
	private String cartProdQuantity;
	
	@Column(length = 250)
	private int userId;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String cartProdName, String cartProdQuantity, int userId) {
		super();
		
		this.cartProdName = cartProdName;
		this.cartProdQuantity = cartProdQuantity;
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCartProdName() {
		return cartProdName;
	}

	public void setCartProdName(String cartProdName) {
		this.cartProdName = cartProdName;
	}

	public String getCartProdQuantity() {
		return cartProdQuantity;
	}

	public void setCartProdQuantity(String cartProdQuantity) {
		this.cartProdQuantity = cartProdQuantity;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	
}
