package com.action;

import com.dao.BookDao;
import com.model.BookModel;
import com.opensymphony.xwork2.ActionSupport;

public class SearchBook extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String callno;
	BookModel model =null;
	
	public String execute() {
		model = BookDao.viewByCallno(callno);
		return SUCCESS;
	}

	public BookModel getModel() {
		return model;
	}

	public void setModel(BookModel model) {
		this.model = model;
	}

	public String getCallno() {
		return callno;
	}

	public void setCallno(String callno) {
		this.callno = callno;
	}
	
	
	

}
