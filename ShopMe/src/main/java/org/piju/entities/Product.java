package org.piju.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prodId;
	private String prodName;
	@Column(name = "prodDes")
	private String desc;
	@Column(name = "prodPrice")
	private int price;
	@Column(name = "prodDiscount")
	private int discount;
	private int prodQuantity;
	
	private String prodImg;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Category category;

	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Product(String prodName, String desc, int price, int discount, int prodQuantity, String prodImg,
			Category category) {
		
		this.prodName = prodName;
		this.desc = desc;
		this.price = price;
		this.discount = discount;
		this.prodQuantity = prodQuantity;
		this.prodImg = prodImg;
		this.category = category;
	}



	public int getProdId() {
		return prodId;
	}



	public void setProdId(int prodId) {
		this.prodId = prodId;
	}



	public String getProdName() {
		return prodName;
	}



	public void setProdName(String prodName) {
		this.prodName = prodName;
	}



	public String getDesc() {
		return desc;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getDiscount() {
		return discount;
	}



	public void setDiscount(int discount) {
		this.discount = discount;
	}



	public int getProdQuantity() {
		return prodQuantity;
	}



	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}



	public String getProdImg() {
		return prodImg;
	}



	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return prodId + " " + prodName + " " + desc + " " + price + " "+ discount + " "+ prodQuantity + " " +prodImg;
	}
	
	
	//calculating price after discount
	
	public int getDiscountedPrice()
	{
		int d = (int)((this.getDiscount()/100.0) * this.getPrice());
		return this.getPrice() - d;
		
	}
	
	
}