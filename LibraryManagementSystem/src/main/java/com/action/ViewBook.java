package com.action;

import java.util.List;

import com.dao.BookDao;
import com.model.BookModel;
import com.opensymphony.xwork2.ActionSupport;

public class ViewBook extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<BookModel> list = null;

	public String execute() {

		list = BookDao.view();
		return SUCCESS;
	}

	public List<BookModel> getList() {
		return list;
	}

	public void setList(List<BookModel> list) {
		this.list = list;
	}

}
