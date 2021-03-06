package com.action;

import com.dao.LibrarianDao;
import com.model.LibrarianModel;
import com.opensymphony.xwork2.ActionSupport;

public class EditLibrarian extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name, email, password;
	private long mobile;

	public String execute() {
		LibrarianModel bean = new LibrarianModel(id, name, email, password, mobile);
		LibrarianDao.update(bean);
		return SUCCESS;
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
