package com.action;

import com.dao.BookDao;
import com.model.BookModel;
import com.opensymphony.xwork2.ActionSupport;

public class AddBook extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String callno, name, author, publisher;
	private int quantity;

	public String execute() {
		BookModel model = new BookModel(callno, name, author, publisher, quantity);
		int i = BookDao.save(model);
		if (i > 0) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
