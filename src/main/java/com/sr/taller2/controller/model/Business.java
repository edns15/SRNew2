package com.sr.taller2.controller.model;

public class Business {
	
	public String id;
	public String name;
	public String address;
	public String city;
	public String state;
	
	public Business(String id, String name, String address, String city, String state){
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
