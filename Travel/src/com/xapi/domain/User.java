package com.xapi.domain;

import java.util.List;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String trueName;
	
	
	public User(String username, String password, String trueName) {
		super();
		this.username = username;
		this.password = password;
		this.trueName = trueName;
	}
	public User() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public User(Integer id, String username, String password, String trueName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.trueName = trueName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", trueName=" + trueName + "]";
	}
	
}
