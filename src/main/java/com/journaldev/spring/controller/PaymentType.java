package com.journaldev.spring.controller;

import java.io.Serializable;

import org.springframework.stereotype.Service;
@Service
public class PaymentType implements Serializable {
	private int user_id;
	private int book_id;
	private int paymentid;
	private String paymenttype;
	private int otp;

	public PaymentType(int user_id, int book_id, int paymentid, String paymenttype, int otp) {
		super();
		this.user_id = user_id;
		this.book_id = book_id;
		this.paymentid = paymentid;
		this.paymenttype = paymenttype;
		this.otp = otp;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
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
	
	
	
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	public PaymentType() {
		
	}
	
}
