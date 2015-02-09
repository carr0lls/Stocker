package com.hackaton.tk;

import java.util.Map;
import java.util.Map.Entry;

import com.firebase.client.Firebase;

public class MarketEmulator {

	private static final int REFRESH_RATE = 2000; 
	private static final int BETTING_TIME = 10000; 
	private static final int GAMING_TIME = 10000; 
	private static final int PAUSE = 5000; 
	
	
	private static Map<String, Stock> stocks = StaticData.stocks;
	private static Firebase ref = new Firebase("https://caroaf.firebaseio.com/");
	
	public static void main(String[] args) {
		Thread generator = getGeneratorThread();
		generator.start();
		Thread sessionManager = getSessionManager();
		sessionManager.run();
	}
	
	private static Thread getGeneratorThread() {
		return new Thread() {
			@Override
			public void run() {
				Firebase quotes = ref.child("stocks");
				while(true) {
					try {
						quotes.setValue(stocks);
						this.sleep(REFRESH_RATE);
						randomizeQuotes();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
	}

	protected static void randomizeQuotes() {
		for(Entry<String, Stock> stockEntry : stocks.entrySet()) {
			Stock stock = stockEntry.getValue();
			double firstLastPrice = stock.getQuotes().get(stock.getQuotes().size()-1).getPrice();
			double secondLastPrice = stock.getQuotes().size() < 2 ? firstLastPrice : stock.getQuotes().get(stock.getQuotes().size()-2).getPrice();
			double thirdLastPrice = stock.getQuotes().size() < 3 ? secondLastPrice : stock.getQuotes().get(stock.getQuotes().size()-3).getPrice();
			
			double diff = firstLastPrice - secondLastPrice;
			double diff2 = secondLastPrice - thirdLastPrice;
			int sign = Math.random() < 0.5 ? -1 : 1;
			double random =  sign * (0.1 + (Math.random()*.5)); 
			double price = firstLastPrice + random + diff/5 + diff2/10;
			stock.addPrice(price);
		}
	}
	
	private static Thread getSessionManager() {
		return new Thread() {
			@Override
			public void run() {
				Firebase sessionsDB = ref.child("bettingSession");
				Firebase currentSessionDB = ref.child("currentSession");
				int id = 1;
				while(true) {
					try {
						BettingSession session = new BettingSession(id);
						session.writeInDB(sessionsDB.child(String.valueOf(id)));
						session.writeInDB(currentSessionDB);
					
						this.sleep(BETTING_TIME);
						session.closeBet(stocks);
						session.writeInDB(sessionsDB.child(String.valueOf(id)));
						session.writeInDB(currentSessionDB);
						this.sleep(GAMING_TIME);
						session.closeGame(stocks);
						session.writeInDB(sessionsDB.child(String.valueOf(id)));
						session.writeInDB(currentSessionDB);
						this.sleep(PAUSE);
						
						id++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
	}

}
