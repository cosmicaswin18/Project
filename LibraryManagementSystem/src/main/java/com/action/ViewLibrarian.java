package com.action;

import java.util.List;

import com.dao.LibrarianDao;
import com.model.LibrarianModel;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ViewLibrarian extends ActionSupport {
	List<LibrarianModel> list =null;
	public String execute() {
	
		list = LibrarianDao.view();
		return SUCCESS;
	}
	public List<LibrarianModel> getList() {
		return list;
	}
	public void setList(List<LibrarianModel> list) {
		this.list = list;
	}
	
}
