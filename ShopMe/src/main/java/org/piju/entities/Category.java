package org.piju.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	private String categoryName;

	@OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
	private List<Product> products = new ArrayList<Product>();

	
	
	public Category(int categoryId, String categoryName) {
	
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String categoryName, List<Product> products) {
	
		
		this.categoryName = categoryName;
		this.products = products;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", products=" + products + "]";
	}

}
