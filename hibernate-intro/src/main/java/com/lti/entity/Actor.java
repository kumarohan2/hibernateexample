package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ACTOR")
public class Actor {
	
	@Id // pk
	@GeneratedValue // used to autogenerate values OF PRIMARY KEY ie Id
	@Column(name="ACTOR_ID")

	private int id;
	private String realName;
	private String stageName;
	private int noOfMovies;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getStageName() {
		return stageName;
	}
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	public int getNoOfMovies() {
		return noOfMovies;
	}
	public void setNoOfMovies(int noOfMovies) {
		this.noOfMovies = noOfMovies;
	}
	
	
	
}
