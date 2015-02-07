package com.hackaton.tk;

import java.util.HashMap;
import java.util.Map;

public class StaticData {
	
	public static Map<String, Stock> stocks = init();
			
	private static Map<String, Stock> init() {
		Map<String, Stock> data = new HashMap<String, Stock>();
		data.put("AAPL", new Stock("AAPL", "Apple", 120.0, APPLE_DESC));
		data.put("F", new Stock("F", "Ford", 7.22, FORD_DESC));
		data.put("MSFT", new Stock("MSFT", "Microsoft", 42.41, MSFT_DESC));
		data.put("SNE", new Stock("SNE", "Sony", 26.12, SONY_DESC));
		data.put("YELP", new Stock("YELP", "Yelp", 44.97, YELP_DESC));
		data.put("ORCL", new Stock("ORCL", "Oracle", 42.98, ORCL_DESC));
		data.put("IBM", new Stock("IBM", "IBM", 156.35, IBM_DESC));
		data.put("TSLA", new Stock("TSLA", "Tesla", 216.97, TSLA_DESC));
		data.put("TWTR", new Stock("TWTR", "Twitter", 48.04, TWTR_DESC));
		data.put("GOOGL", new Stock("GOOGL", "Google", 531.00, GOOGL_DESC));
		return data;
	}
	
	public static final String APPLE_DESC = "Apple Inc. (Apple) designs, manufactures and markets mobile communication and media devices, personal computers, and portable digital music players, and a variety of related software, services, peripherals, networking solutions, and third-party digital content and applications. The Company's products and services include iPhone, iPad, Mac, iPod, Apple TV, a portfolio of consumer and professional software applications, the iOS and OS X operating systems, iCloud, and a variety of accessory, service and support offerings.";
	public static final String FORD_DESC = "Ford Motor Company (Ford) is a manufacturer of automobiles. The Company together with its subsidiaries is engaged in other businesses, including financing vehicles. The Company operates in two segments: Automotive and Financial Services. Automotive includes Ford North America, Ford South America, Ford Europe, Ford Middle East & Africa and Ford Asia Pacific. ";
	public static final String MSFT_DESC = "Microsoft Corporation is engaged in developing, licensing and supporting a range of software products and services. The Company also designs and sells hardware, and delivers online advertising to the customers. The Company operates in five segments: Devices and Consumer (D&C) Licensing, D&C Hardware, D&C Other, Commercial Licensing, and Commercial Other.";
	public static final String SONY_DESC = "SONY CORPORATION is engaged in the operation of imaging products and solution (IP&S), game, mobile products and communication (MP&C), home entertainment and sound (HE&S), device, movie, music, financial and other business. IP&S segment provides digital imaging products and professional solutions. Game segment produces and distributes consumer game machines and software.";
	public static final String YELP_DESC = "Yelp Inc. connects people with great local businesses. Its users have contributed a total of approximately 36.0 million cumulative reviews of almost every type of local business, from restaurants, boutiques and salons to dentists, mechanics and plumbers. Its platform provides local businesses with a range of free and paid services, which help them to engage with consumers at moment when they are deciding where to spend their money.";
	public static final String ORCL_DESC = "Oracle Corporation is a provider of enterprise software and computer hardware products and services. The Company provides cloud services as well as software and hardware products to other cloud service providers, both public and private. The Company’s software business consists of two segments: new software licenses and cloud software subscriptions and software license updates and product support.";
	public static final String IBM_DESC = "International Business Machines Corporation (IBM) is an information technology (IT) company. IBM operates in five segments: Global Technology Services (GTS), Global Business Services (GBS), Software, Systems and Technology and Global Financing. GTS primarily provides IT infrastructure services and business process services.";
	public static final String TSLA_DESC = "Tesla Motors, Inc. (Tesla) designs, develops, manufactures and sells electric vehicles and advanced electric vehicle powertrain components. Tesla owns its sales and service network. The Company is engaged in commercially producing a federally-compliant electric vehicle, the Tesla Roadster.";
	public static final String TWTR_DESC = "Twitter, Inc. (Twitter) is a global platform for public self-expression and conversation in real time. It is a real-time platform, where any user can create a Tweet and any user can follow other users.Viewers can see photos, videos and conversations directly in Tweets to get the whole story at a glance, and all in one place.";
	public static final String GOOGL_DESC = "Google Inc. (Google) is a global technology company. The Company’s business is primarily focused around key areas, such as search, advertising, operating systems and platforms, enterprise and hardware products. The Company generates revenue primarily by delivering online advertising. The Company provides its products and services in more than 100 languages and in more than 50 countries, regions, and territories.";
	
}
