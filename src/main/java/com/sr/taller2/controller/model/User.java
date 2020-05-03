package com.sr.taller2.controller.model;

public class User {
	
	public String id;
	public String username;
	public String yearsAsElite;
	
	public User(String id, String username, String yearsAsElite){
		this.id = id;
		this.username = username;
		this.yearsAsElite = yearsAsElite;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getYearsAsElite() {
		return yearsAsElite;
	}

	public void setYearsAsElite(String yearsAsElite) {
		this.yearsAsElite = yearsAsElite;
	}
}
