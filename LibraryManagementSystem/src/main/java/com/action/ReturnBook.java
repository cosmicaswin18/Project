package com.action;

import com.dao.BookDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ReturnBook extends ActionSupport{
	
	private String callno;
	private String studentid;
	
	public String execute() {
		int i = BookDao.returnBook(callno, studentid);
		if(i>0) { 
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String getCallno() {
		return callno;
	}

	public void setCallno(String callno) {
		this.callno = callno;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	

}
