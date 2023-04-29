package org.piju.helperClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryProvider {

	private static EntityManagerFactory emf;
	
	public static EntityManagerFactory getEMFactory()
	{
		if (emf == null) {
			
			emf = Persistence.createEntityManagerFactory("dev");
			
		}
		
		return emf;
	}
	
	public static EntityManager getEM()
	{
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
	
}
