package org.piju.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.piju.entities.User;
import org.piju.helperClass.FactoryProvider;

public class UserDao {

	private EntityManager entityManager = FactoryProvider.getEMFactory().createEntityManager();
	
	private EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	public User getUserByEmail(String email)
	{
		Query query = entityManager.createQuery("from User where email =: x");
		query.setParameter("x", email);
		User user = (User) query.getSingleResult();
		return user;
	}
	
	public int userCount()
	{
		Query query = entityManager.createQuery("from User where userType = 'normal'");
		List<User> list = query.getResultList();
		
		return (list.size());
	}
	
	public void saveUser(User user)
	{
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
	}
}
