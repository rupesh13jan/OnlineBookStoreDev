package com.journaldev.spring.controller;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class Payment{


	private int user_id;
	private int book_id;
	private int paymentid;

	public int getUser_id() {
		return user_id;
	}
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	
	
	public Payment(int user_id, int book_id, int paymentid) {
		super();
		this.user_id = user_id;
		this.book_id = book_id;
		this.paymentid = paymentid;
	}
	public Payment() {
		
	}
}
