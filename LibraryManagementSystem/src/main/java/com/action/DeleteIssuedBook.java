package com.action;

import com.dao.BookDao;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteIssuedBook extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String callno;

	public String execute() {
		BookDao.deleteissue(callno);
		return SUCCESS;
	}

	public String getCallno() {
		return callno;
	}

	public void setCallno(String callno) {
		this.callno = callno;
	}


}
