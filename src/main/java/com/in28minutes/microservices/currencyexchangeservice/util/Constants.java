package com.in28minutes.microservices.currencyexchangeservice.util;

public class Constants {
	
	public class Api
	{
		public static final String EXCHANGE_FROM_TO = "/currency-exchange/from/{from}/to/{to}";
		
		public static final String EXCHANGE_TEST = "/currency-exchange/getSystemInfo";
		
		public static final String EXCHANGE_SEND_QUEUE = "/currency-exchange/sendInfoToQueue";

	}

}
