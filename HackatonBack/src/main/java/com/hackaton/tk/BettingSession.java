package com.hackaton.tk;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.firebase.client.Firebase;

public class BettingSession {
	
	public static final String BETTING = "Betting";
	public static final String PENDING = "Pending";
	public static final String CLOSED = "Closed";
	
	private final int id;
	private String status = BETTING;
	private Map<String, Double> resultValues = new HashMap<String, Double>();
	private Map<String, Double> startValues = new HashMap<String, Double>();
	
	public BettingSession(int id) {
		this.id = id;
	}
	
	private void addResultValue(String quote, Double price) {
		resultValues.put(quote, price);
	}
	
	private void addStartValue(String quote, Double price) {
		startValues.put(quote, price);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Map<String, Double> getResultValues() {
		return resultValues;
	}
	
	public Map<String, Double> getStartValues() {
		return startValues;
	}


	public int getId() {
		return id;
	}
	
	public void writeInDB(Firebase db) {
		db.child("status").setValue(getStatus());
		db.child("startValues").setValue(getStartValues());
		db.child("resultValues").setValue(getResultValues());
	}

	public void closeBet(Map<String, Stock> stocks) {
		status = PENDING;
		for(Entry<String, Stock> stockEntry : stocks.entrySet()) {
			Stock stock = stockEntry.getValue();
			addStartValue(stock.getQuoteName(), stock.getQuotes().get(stock.getQuotes().size()-1).getPrice());
		}
	}
	
	public void closeGame(Map<String, Stock> stocks) {
		status = CLOSED;
		for(Entry<String, Stock> stockEntry : stocks.entrySet()) {
			Stock stock = stockEntry.getValue();
			addResultValue(stock.getQuoteName(), stock.getQuotes().get(stock.getQuotes().size()-1).getPrice());
		}
	}
}
