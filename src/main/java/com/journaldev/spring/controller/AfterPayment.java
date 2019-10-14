package com.journaldev.spring.controller;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class AfterPayment {

	private String paymentstatus;
	private String paymenttype;
	private int otp;

	public AfterPayment(String paymentstatus, String paymenttype, int otp) {
		super();
		this.paymentstatus = paymentstatus;
		this.paymenttype = paymenttype;
		this.otp = otp;
	}

	public AfterPayment(String paymentstatus, String paymenttype) {
		super();
		this.paymentstatus = paymentstatus;
		this.paymenttype = paymenttype;
		
	}
	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public AfterPayment() {

	}

}
