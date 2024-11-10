package com.in28minutes.microservices.currencyexchangeservice;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.util.Constants;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	private CurrencyExchangeRepository repository;

	@Autowired
	private Environment environment;

	@GetMapping(Constants.Api.EXCHANGE_FROM_TO)
	public APIResponse retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		APIResponse response = new APIResponse();
		CurrencyExchangeRate currencyExchange = null;
		try
		{
			logger.info("retrieveExchangeValue called with {} to {}", from, to);
	
			currencyExchange = repository.findByFromAndTo(from, to);
			
			String port = environment.getProperty("local.server.port");
			String hostName = InetAddress.getLocalHost().getHostName();
			
			response.setHostName(hostName);
			response.setPort(port);
			
			if (currencyExchange == null) {
				throw new RuntimeException("Unable to Find data for " + from + " to " + to);
			}
	
			response.setData(currencyExchange);			
			response.setStatus("SUCCESS");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			String message=ee.getMessage();
			response.setStatus("FAILURE");
			response.setError(true);
			response.setMessage(message);
		}

		return response;

	}

}
