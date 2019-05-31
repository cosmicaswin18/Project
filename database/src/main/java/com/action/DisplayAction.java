package com.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.service.DisplayService;

@SuppressWarnings("serial")
public class DisplayAction extends ActionSupport {

	private int pid, pqty;
	private String pname;
	private float pprice;

	List<DisplayAction> list = null;
	ResultSet rs = null;

	public String execute() throws Exception {
		try {
			list = new ArrayList<DisplayAction>();
			rs = DisplayService.display(this);
			if (rs != null) {
				while (rs.next()) {
					DisplayAction DA = new DisplayAction();
					DA.setPid(rs.getInt(1));
					DA.setPname(rs.getString(2));
					DA.setPqty(rs.getInt(3));
					DA.setPprice(rs.getFloat(4));
					list.add(DA);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public ArrayList<DisplayAction> getList() {
		return (ArrayList<DisplayAction>) list;
	}

	public void setList(ArrayList<DisplayAction> list) {
		this.list = list;
	}

	public int getPqty() {
		return pqty;
	}

	public void setPqty(int pqty) {
		this.pqty = pqty;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public float getPprice() {
		return pprice;
	}

	public void setPprice(float pprice) {
		this.pprice = pprice;
	}

}
