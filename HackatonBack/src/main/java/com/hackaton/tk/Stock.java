package com.hackaton.tk;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	private String quote;
	private String name;
	private String description;
	private List<Quote> prices = new ArrayList<Quote>();
	
	public String getQuoteName() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public List<Quote> getQuotes() {
		return prices;
	}

	public void addPrice(Double price) {
		BigDecimal bd = new BigDecimal(price);
	    bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		prices.add(new Quote(bd.doubleValue()));
	}
	
	public Stock(String quote, String name, double price, String description){
		this.quote = quote;
		this.name = name;
		prices.add(new Quote(price));
		this.description = description;
	}
}
