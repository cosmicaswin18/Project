package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.service.DeleteService;

@SuppressWarnings("serial")
public class DeleteAction extends ActionSupport {

	public int pid;

	public String execute() throws Exception {

		int var = DeleteService.delete(this);
		if (var > 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public int getPid() {
		return pid;
	}

	public void setId(int pid) {
		this.pid = pid;
	}

	

}
