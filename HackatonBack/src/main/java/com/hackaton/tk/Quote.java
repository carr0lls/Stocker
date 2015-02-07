package com.hackaton.tk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Quote {

	private static final SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
	
	private Date date = new Date();
	private double price;
	
	public Quote(double price) {
		this.price = price;
	}
	
	public String getDate() {
		return dt.format(date);
	}
	
	public double getPrice() {
		return price;
	}
}
