package com.action;

import com.dao.BookDao;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteIssuedBook extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String callno;
	private String studentid;

	public String execute() {
		BookDao.deleteissue(callno,studentid);
		return SUCCESS;
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
