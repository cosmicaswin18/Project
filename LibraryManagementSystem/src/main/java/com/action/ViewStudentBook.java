package com.action;

import java.util.List;

import com.dao.BookDao;
import com.model.StudentModel;
import com.opensymphony.xwork2.ActionSupport;

public class ViewStudentBook extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<StudentModel> list = null;
	private String studentid;
	
	public String execute() {
		
		list = BookDao.viewStudentBooks(studentid);
		return SUCCESS;
	}

	public List<StudentModel> getList() {
		return list;
	}

	public void setList(List<StudentModel> list) {
		this.list = list;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

}
