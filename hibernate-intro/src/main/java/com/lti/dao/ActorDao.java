package com.lti.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Actor;

public class ActorDao {
	public void add(Actor actor) {
		// Step 1. create/obtain entityManagerFactory object
		// During this step,META-INF/persistence.xml file will be read
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-unit");

		// Step 2: Create / obtain EntityManager object
		// Druing this step, a connection will be opened to the database

		EntityManager em = emf.createEntityManager();

		// Step 3. Start/Participate in a transaction
		// Hibernate dosen't auto commits, we need to take care of it
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// Now we can insert/update/delete/select whateve we want
		em.persist(actor); // persist method will generate insert query for us

		tx.commit();

		// below code should be in finally block
		em.close();
		emf.close();

	}

/*public Actor fetch(int actorId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-unit");
		EntityManager em = emf.createEntityManager();
		Actor a = em.find(Actor.class, actorId);
		em.close();
		emf.close();
		return a;

	} */

	public List<Actor> fetchAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-unit");
		EntityManager em = emf.createEntityManager();
		String jpql = "select a from Actor as a";
		Query q = em.createQuery(jpql);
		List<Actor> actors = q.getResultList();
		
		em.close();
		emf.close();
		return actors;
	}
	public List<Actor> fetchByInitial(String actorname) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-unit");
		EntityManager em = emf.createEntityManager();
		String jpql = "select a from Actor as a where a.stageName like:'name%'";
		Query q = em.createQuery(jpql);
		q.setParameter("name", actorname);
		List<Actor> actors = q.getResultList();

		
		em.close();
		emf.close();
		return actors;
	/*public List<Actor> fetchbyMovie(int noOfmovies) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-unit");
		EntityManager em = emf.createEntityManager();
		String jpql = "select a from Actor as a where a.noOfmovies >= :no";
		Query q = em.createQuery(jpql);
		q.setParameter("no", noOfmovies);
		List<Actor> actors = q.getResultList();
		
		em.close();
		emf.close();
		return actors;
	} */
}
}