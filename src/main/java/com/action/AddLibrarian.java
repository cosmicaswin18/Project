package com.action;

import com.dao.CheckDao;
import com.dao.LibrarianDao;
import com.model.LibrarianModel;
import com.opensymphony.xwork2.ActionSupport;

public class AddLibrarian extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name, email, password;
	private long mobile;

	public String execute() {

		LibrarianModel model = new LibrarianModel(name, email, password, mobile);
		String smobile = Long.toString(mobile);
		if(!CheckDao.phone(smobile)||!CheckDao.em(email)) {
			return ERROR;
		}
		if (LibrarianDao.save(model) > 0) {
			return SUCCESS;
		} else {
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
