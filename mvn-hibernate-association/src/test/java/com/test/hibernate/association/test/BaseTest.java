package com.test.hibernate.association.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseTest {

	@Autowired
	protected SessionFactory factory;

	protected void save(Object entity) {
		System.out.println("");
		// Create
		Session session = factory.openSession();
		session.beginTransaction();
		Serializable id = session.save(entity);
		session.getTransaction().commit();
		session.close();
		System.out.println("Entity saved to DB : " + entity);
		Assert.assertNotNull(id);
	}

	protected void saveAndFindAndDelete(Object entity) {
		System.out.println("");
		// Create
		Session session = factory.openSession();
		session.beginTransaction();
		Serializable id = session.save(entity);
		session.getTransaction().commit();
		session.close();
		System.out.println("Entity saved to DB : " + entity);
		Assert.assertNotNull(id);

		// Read
		session = factory.openSession();
		Object dbEntity = session.get(entity.getClass(), id);
		System.out.println("DB Entity found : " + dbEntity);
		session.close();
		Assert.assertNotNull(dbEntity);

		// Delete
		session = factory.openSession();
		session.beginTransaction();
		session.delete(dbEntity);
		session.getTransaction().commit();
		session.close();
		System.out.println("Entity deleted from DB.");	
	}
}
