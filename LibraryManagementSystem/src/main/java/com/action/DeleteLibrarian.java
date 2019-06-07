package com.action;

import com.dao.LibrarianDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteLibrarian extends ActionSupport {
	
	int id;
	
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
