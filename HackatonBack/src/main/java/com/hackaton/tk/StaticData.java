package com.hackaton.tk;

import java.util.HashMap;
import java.util.Map;

public class StaticData {
	
	public static Map<String, Stock> stocks = init();
			
	private static Map<String, Stock> init() {
		Map<String, Stock> data = new HashMap<String, Stock>();
		data.put("AAPL", new Stock("AAPL", "Apple", 120.0));
		data.put("F", new Stock("F", "Ford", 7.22));
		data.put("MSFT", new Stock("MSFT", "Microsoft", 42.41));
		data.put("SNE", new Stock("SNE", "Sony", 26.12));
		data.put("YELP", new Stock("YELP", "Yelp", 44.97));
		data.put("ORCL", new Stock("ORCL", "Oracle", 42.98));
		data.put("IBM", new Stock("IBM", "IBM", 156.35));
		data.put("TSLA", new Stock("TSLA", "Tesla", 216.97));
		data.put("TWTR", new Stock("TWTR", "Twitter", 48.04));
		data.put("GOOG", new Stock("GOOG", "Google", 531.00));
		return data;
	}
	
}
