package org.piju.dao;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.piju.entities.Category;
import org.piju.entities.Product;
import org.piju.entities.User;

public class AdminDao {

	private EntityManager entityManager;
	
	

	public AdminDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void addCategory(Category category)
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(category);
		transaction.commit();
	}
	
	public List<Category> getCategory()
	{
		Query query = entityManager.createQuery("from Category");
		List<Category> list = query.getResultList();
		return list;
	}
	
	public Category getCategoryById(int id)
	{
		Category category = entityManager.find(Category.class, id);
		return category;
	}
	
	public void addProduct(Product product)
	{
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(product);
		entityTransaction.commit();
	}
	
	public List<Product> getProducts()
	{
		Query query = entityManager.createQuery("from Product");
		List<Product> list = query.getResultList();
		return list;
	}
	
//	public List<Product> getProductsByLimit(int start, int end)
//	{
//		Query query = entityManager.createNativeQuery("select * from shopme.Product limit "+(start-1)+","+end);
//		List<Object[]> list = query.getResultList();
//		List<Product> products = null;
//		for (Object[] objects : list) {
//			Product product = new Product();
//			product.setProdId(Integer.parseInt(objects[0].toString()));
//			product.setProdName(objects[5].toString());
//			product.setDesc(objects[1].toString());
//			product.setPrice(Integer.parseInt(objects[3].toString()));
//			product.setDiscount(Integer.parseInt(objects[2].toString()));
//			product.setProdQuantity(Integer.parseInt(objects[6].toString()));
//			product.setProdImg(objects[4].toString());
//			product.setCategory((Category) objects[7]);
//			products.add(product);
//		}
		
//		return products;
//	}
	
	public List<Product> getProductsById(int id)
	{
		Query query = entityManager.createQuery("from Product where category.categoryId =: x");
		query.setParameter("x", id);
		List<Product> list = query.getResultList();
		return list;
	}
	
	public int categoryCount()
	{
		Query query = entityManager.createQuery("from Category");
		List<Category> list = query.getResultList();
		
		return (list.size());
	}
	
	public int productCount()
	{
		Query query = entityManager.createQuery("from Product");
		List<Product> list = query.getResultList();
		
		return (list.size());
	}
	
	public void deleteCategory(int id)
	{
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Category category = entityManager.find(Category.class, id);
		entityManager.remove(category);
		entityTransaction.commit();
	}
	public void deleteProduct(int id)
	{
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Product product = entityManager.find(Product.class, id);
		entityManager.remove(product);
		entityTransaction.commit();
	}
	
	public Product getProductById(int id)
	{
		Product product = entityManager.find(Product.class, id);
		return product;
	}
	
}
