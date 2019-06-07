package com.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AdminLogin extends ActionSupport implements SessionAware {

	private String email;
	private String password;
	private SessionMap<String, Object> sessionMap;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap<String, Object>) map;
	}

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		if (email != null) {
			if (email.equals("admin@jtp.com") && password.equals("admin123")) {
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
			System.out.println("asdfgh" + sessionMap);
			sessionMap.invalidate();
			sessionMap.clear();
		System.out.println("qwertyui" + sessionMap);
		return "Logout";
	}

}
