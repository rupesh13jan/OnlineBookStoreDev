package com.journaldev.spring.controller;

import java.io.Serializable;

import org.springframework.stereotype.Service;
@Service
public class AfterOrder  {
	
	private int paymentID;
	public AfterOrder(int paymentID, String paymentStatus) {
		super();
		this.paymentID = paymentID;
		this.paymentStatus = paymentStatus;
	}
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	private String paymentStatus;
	
	public AfterOrder() {
		
	}
}
