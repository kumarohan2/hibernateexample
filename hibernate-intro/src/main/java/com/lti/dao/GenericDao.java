package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Table;

public class GenericDao { // CommonDao,BaseDao,sabkaDao,SarvajanikDao

	public void merge(Object obj) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			emf = Persistence.createEntityManagerFactory("oracle-unit");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.merge(obj); // merge method can be used for insert as well update both

			tx.commit();
		} finally {
			em.close();
			emf.close();
		}
	}

	public <T> T fetch(Class<T> clazz, Object pk) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracle-unit");
			em = emf.createEntityManager();
			T t = em.find(clazz, pk);
			return t;
		} finally {
			em.close();
			emf.close();
		}
	}

	public <T> List<T> fetchAll(Class<T> clazz) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracle-unit");
			em = emf.createEntityManager();
			String jpql = "select obj from " + clazz.getName() + "as obj";
			return em.createQuery(jpql, clazz).getResultList();

		} finally {
			em.close();
			emf.close();
		}
	}
}