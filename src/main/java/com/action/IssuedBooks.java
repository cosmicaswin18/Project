package com.action;

import java.util.List;

import com.dao.BookDao;
import com.model.IssueBookModel;
import com.opensymphony.xwork2.ActionSupport;

public class IssuedBooks extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String callno;
	List<IssueBookModel> list = null;
	
	public String execute() {
		list = BookDao.viewIssuedBooksById(callno);
		return SUCCESS;
	}

	public String getCallno() {
		return callno;
	}

	public void setCallno(String callno) {
		this.callno = callno;
	}

	public List<IssueBookModel> getList() {
		return list;
	}

	public void setList(List<IssueBookModel> list) {
		this.list = list;
	}
	
	

}
