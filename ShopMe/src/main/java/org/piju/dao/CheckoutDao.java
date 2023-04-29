package org.piju.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.piju.entities.Orders;
import org.piju.entities.Product;
import org.piju.entities.ShippingDetails;
import org.piju.entities.User;

public class CheckoutDao {

	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public CheckoutDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckoutDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}



	public void saveOrders(Orders orders)
	{
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(orders);
		entityTransaction.commit();
		System.out.println("saved order");
	}
	
	public int getUserId(String email)
	{
		
		Query query = entityManager.createQuery("from User where email =: x");
		query.setParameter("x", email);
		User user = (User) query.getSingleResult();
		int id = user.getId();
		System.out.println(id);
		return id;
	}
	
	public int getOrderId(int userId)
	{
		Query query = entityManager.createQuery("from Orders where userId =: x");
		query.setParameter("x", userId);
		int id = query.getFirstResult();
		return id;
	}
	
	public void saveShippingDetails(ShippingDetails details)
	{
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(details);
		entityTransaction.commit();
	}
	
	public void decreaseQuanity(String prodName, int quantity)
	{
		Query query = entityManager.createQuery("from Product where prodName =: x");
		query.setParameter("x", prodName);
		Product product = (Product) query.getSingleResult();
		int oldQuantity = product.getProdQuantity();
		product.setProdQuantity(oldQuantity - quantity);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(product);
		entityTransaction.commit();
		
	}
	
}
