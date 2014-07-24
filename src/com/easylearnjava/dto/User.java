package com.easylearnjava.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User implements Serializable{

	/**
	 * This is auto generated
	 */
	private static final long serialVersionUID = -8817036715620695419L;

	@Id
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="USER_PASSWORD")
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(){
		
	}

	public User(int userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	
	

}
