package com.action;

import com.service.RegisterService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport {
	int id;
	String name, email, city, password;
	public String uname;
	
	public String execute() throws Exception {
		
		int var = RegisterService.register(this);
		if (var > 0) {
			return "SUCCESS";
		} else {
			return "input";
		}
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUserName() {
		return uname;
	}

	public void setUserName(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
