package com.action;

import com.dao.BookDao;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteBook extends ActionSupport {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private String callno;

	public String execute() {
		BookDao.delete(callno);
		return SUCCESS;
	}

	public String getCallno() {
		return callno;
	}

	public void setCallno(String callno) {
		this.callno = callno;
	}

}
