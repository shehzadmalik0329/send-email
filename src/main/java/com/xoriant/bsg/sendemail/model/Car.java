package com.xoriant.bsg.sendemail.model;

import java.util.Date;

public class Car {
	
	public String number;
	
	public Date issueDate;

	public Car() {
	}

	public Car(String number, Date issueDate) {
		this.number = number;
		this.issueDate = issueDate;
	}

	@Override
	public String toString() {
		return "Car [number=" + number + ", issueDate=" + issueDate + "]";
	}
	
}
