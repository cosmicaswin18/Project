package com.action;

import com.dao.LibrarianDao;
import com.model.LibrarianModel;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddLibrarian extends ActionSupport {
	
	private String name,email,password;
	private long mobile;
	
	public String execute(){
		
		LibrarianModel model = new LibrarianModel(name, email, password, mobile);
		if(LibrarianDao.save(model)>0) {
			return SUCCESS;
		}else {
			return ERROR;
		}
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	

}
