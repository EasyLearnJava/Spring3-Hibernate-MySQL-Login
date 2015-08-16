package com.easylearnjava.model;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {

	@NotEmpty
	@Size(min = 5, max = 20)
	private String userName;
	
	@NotEmpty
	@Size(min = 6, max = 15, message = "User custom message says, min size is 6 and max is 15 characters")
	private String password;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
