package com.action;



import com.opensymphony.xwork2.ActionSupport;
import com.service.AddService;

@SuppressWarnings("serial")
public class AddAction extends ActionSupport {

	public int pid;
	public int pqty;
	public String pname;
	public float pprice;

	public String execute() throws Exception {

		int var = AddService.add(this);
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

	public String getName() {
		return pname;
	}

	public void setName(String pname) {
		this.pname = pname;
	}

	public int getPqty() {
		return pqty;
	}

	public void setPqty(int pqty) {
		this.pqty = pqty;
	}

	public float getPprice() {
		return pprice;
	}

	public void setPprice(float pprice) {
		this.pprice = pprice;
	}

}
