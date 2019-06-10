package com.action;

import com.dao.LibrarianDao;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteLibrarian extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;

	public String execute() {
		LibrarianDao.delete(id);
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
