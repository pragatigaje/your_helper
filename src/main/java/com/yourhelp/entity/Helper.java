package com.yourhelp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Helper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String type;
	
	private String username;
	
	private String password;
	
	private float cost ;
	
	private String mobile;

	public Helper() {
		
	}
	
	
	public Helper(int id) {
		super();
		this.id = id;
	}
	
	
	public Helper(String type) {
		super();
		this.type = type;
	}


	public Helper(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}


	public Helper(String name, String type, String username, String password, float cost, String mobile) {
		super();
		this.name = name;
		this.type = type;
		this.username = username;
		this.password = password;
		this.cost = cost;
		this.setMobile(mobile);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
