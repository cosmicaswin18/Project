package com.action;

import com.dao.BookDao;
import com.model.IssueBookModel;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class IssueBook extends ActionSupport {
	
	private String callno,studentid,studentname;
	private long studentmobile;
	
	public String execute() {
		IssueBookModel model = new IssueBookModel(callno, studentid, studentname, studentmobile);
		int i = BookDao.issueBook(model);
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

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public long getStudentmobile() {
		return studentmobile;
	}

	public void setStudentmobile(long studentmobile) {
		this.studentmobile = studentmobile;
	}
	
}
