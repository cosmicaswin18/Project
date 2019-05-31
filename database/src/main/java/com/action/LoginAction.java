package com.action;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.service.LoginService;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements SessionAware{

	private String user;
	private String password;
	private String name;
	private SessionMap<String, Object> sessionMap;

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		int ret = LoginService.login(this);
		if(user != null) {
		if (ret == 1) {
			sessionMap.put("user", user);
			return SUCCESS;
		} else {
			return ERROR;
		}

	}else {
		String getSessionAttr = (String) session.getAttribute("user");
		
		if (getSessionAttr != null) {

			return SUCCESS;

		} else {
			return ERROR;
		}
	}
	}
	public String logout() {
		sessionMap.remove("user");
		sessionMap.invalidate();
		return "Logout";
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public SessionMap<String, Object> getSessionMap() {
//		return sessionMap;
//	}

//	public void setSessionMap(Map<String, Object> sessionMap) {
//		this.sessionMap = sessionMap;
//	}
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap<String, Object>) map;
	}
	
}
