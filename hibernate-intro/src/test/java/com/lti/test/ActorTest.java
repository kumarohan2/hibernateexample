package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.dao.ActorDao;
import com.lti.entity.Actor;

public class ActorTest {

	@Test
	public void addActor() {

		Actor actor = new Actor();
		actor.setStageName("SRK");
		actor.setRealName("SHAH RUKH KHAN");
		actor.setNoOfMovies(99999999);
		
		ActorDao dao= new ActorDao();
		dao.add(actor);
		}
	@Test
	public void fetch() {
		ActorDao dao= new ActorDao();
		Actor a = dao.fetch(1);
		assertNotNull(a);
		System.out.println(a.getStageName());
		System.out.println(a.getRealName());
		System.out.println(a.getNoOfMovies());
	}
}
