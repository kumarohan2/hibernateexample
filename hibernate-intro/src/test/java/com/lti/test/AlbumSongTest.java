package com.lti.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Album;
import com.lti.entity.Song;

public class AlbumSongTest {

	@Test
	public void test() {
		Album a = new Album();

		a.setName("Starboy");
		a.setCopyrightInfo("Internationl");

		GenericDao dao= new GenericDao();
		dao.merge(a);
	}

	@Test
	public void addSongsToExistingAlbum() {
		GenericDao dao = new GenericDao();
		Album a =dao.fetch(Album.class,103); //check the album id
		
		Song s1=new Song();
		s1.setTitle("Badne lagi");
		s1.setDuration(120);
		s1.setAlbum(a);
		
		Song s2=new Song();
		s2.setTitle("Wht is your name");
		s2.setDuration(120);
		s2.setAlbum(a);
		
		Song s3=new Song();
		s3.setTitle("sadness");
		s3.setDuration(120);
		s3.setAlbum(a);
		
		dao.merge(s1);
		dao.merge(s2);
		dao.merge(s3);
		}
	
	@Test
	public void addNewAlbumAlongWithSomeSongs() {
		Album a = new Album();
		a.setName("Java 755");
		a.setCopyrightInfo("LTI");
		
		Song s1 = new Song();
		s1.setTitle("hum honge kamyaab");
		s1.setDuration(120);
		s1.setAlbum(a);
		
		Song s2 = new Song();
		s2.setTitle("see ya again");
		s2.setDuration(220);
		s2.setAlbum(a);
		
		Set<Song> songs = new HashSet<Song>();
		songs.add(s1);
		songs.add(s2);
		a.setSongs(songs);
		
		GenericDao dao = new GenericDao();
		dao.merge(a);
	}
	

}
