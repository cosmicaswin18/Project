package com.action;

import java.util.List;

import com.dao.BookDao;
import com.model.IssueBookModel;
import com.opensymphony.xwork2.ActionSupport;

public class ViewIssuedBook extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<IssueBookModel> list = null;

	public String execute() {

		list = BookDao.viewIssuedBooks();
		return SUCCESS;
	}

	public List<IssueBookModel> getList() {
		return list;
	}

	public void setList(List<IssueBookModel> list) {
		this.list = list;
	}

}
