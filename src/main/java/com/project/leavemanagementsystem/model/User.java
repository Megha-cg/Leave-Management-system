package com.project.leavemanagementsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="Users")
public class User {

	
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@JsonIgnore
	@JsonProperty(access = Access.READ_ONLY)
	private int id;
	
	@Id
	@Column(nullable=false, name="user_name", unique=true)
	private String userName;
	
	@JsonIgnore
	@JsonProperty(access = Access.READ_ONLY)
	@Column(nullable=false,unique=true)
	private String email;
	
	@Column(nullable=false)
	private String role;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(nullable=false)
	//@Size(min=8)
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}