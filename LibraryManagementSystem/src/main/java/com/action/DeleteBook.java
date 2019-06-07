package com.action;

import com.dao.BookDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteBook extends ActionSupport{
	
String callno;
	
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
