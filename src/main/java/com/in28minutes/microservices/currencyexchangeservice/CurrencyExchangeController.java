package com.in28minutes.microservices.currencyexchangeservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeService service;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
			@PathVariable String to) {
		
		logger.info("retrieveExchangeValue called with {} to {}", from, to);
		
		CurrencyExchange currencyExchange = service.findByFromAndTo(from, to);
		
		if(currencyExchange ==null) {
			throw new RuntimeException
				("Unable to Find data for " + from + " to " + to);
		}
		
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		
		logger.info("retrieveExchangeValue response {}", currencyExchange.toString());
		
		return currencyExchange;
		
	}
	
	@GetMapping("/currency-exchange/getAllExchangeValues")
	public List<CurrencyExchange> getAllExchangeValues() {
		
		logger.info("getAllExchangeValues called with {} to {}");
		
		List<CurrencyExchange> currencyExchangeList = service.getAllCurrencyExchanges();
		
		return currencyExchangeList;
		
	}
	
	@PostMapping("/currency-exchange/pushToQueue")
	public CurrencyExchange submitExchangeToQueue(@RequestBody CurrencyExchange currencyExchange) {
		
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		
		logger.info("submitExchangeToQueue response {}", currencyExchange.toString());
		
		service.addCurrencyExchange(currencyExchange.getRecordId(), currencyExchange.getFrom(), currencyExchange.getTo(), currencyExchange.getConversionMultiple());
		
		return currencyExchange;
		
	}
	
	@PostMapping("/currency-exchange/pushToLambda")
	public CurrencyExchange submitExchangeToLamda(@RequestBody CurrencyExchange currencyExchange) {
		
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		
		logger.info("submitExchangeToLamda response {}", currencyExchange.toString());
		
		return currencyExchange;
		
	}
	
	@PostMapping("/currency-exchange/pushAllExchangeValues")
	public void pushAllExchangeValues() {
		
		logger.info("getAllExchangeValues called with {} to {}");
		
		List<CurrencyExchange> currencyExchangeList = repository.findAll();
		
	}
	
}
