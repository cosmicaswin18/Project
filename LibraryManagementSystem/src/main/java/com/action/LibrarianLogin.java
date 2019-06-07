package com.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.dao.LibrarianDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LibrarianLogin extends ActionSupport implements SessionAware {

	private String email;
	private String password;
	private SessionMap<String, Object> sessionMap;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		if (email != null) {
			if (LibrarianDao.authenticate(email, password)) {

				sessionMap.put("email", email);
				return SUCCESS;
			} else {
				return ERROR;
			}
		} else {
			String getSessionAttr = (String) session.getAttribute("email");

			if (getSessionAttr != null) {

				return SUCCESS;

			} else {
				return ERROR;
			}
		}
	}

	public String logout() {
		sessionMap.remove("email");
		sessionMap.invalidate();
		return "LogoutLib";
	}

	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap<String, Object>) map;
	}
}
