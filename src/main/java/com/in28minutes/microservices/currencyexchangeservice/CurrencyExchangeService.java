package com.in28minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {
	
	@Autowired
    CurrencyExchangeRepository currencyExchangeRepository;
	
	public List<CurrencyExchange> getAllCurrencyExchanges(){
        return currencyExchangeRepository.findAll();
    }
	
    public CurrencyExchange findByFromAndTo(String from, String to){
        CurrencyExchange exchange = currencyExchangeRepository.findByFromAndTo(from,to);
        return exchange;
    }
    
    public CurrencyExchange addCurrencyExchange(String id,String from, String to,BigDecimal converseMultiple) {
    	CurrencyExchange exchange = new CurrencyExchange();
    	exchange.setId(id);
    	exchange.setFrom(from);
    	exchange.setTo(to);
    	exchange.setConversionMultiple(converseMultiple);
    	       
        return currencyExchangeRepository.save(exchange);
    }
    
    public String deleteCurrencyExchange(String from, String to){
    	CurrencyExchange exchange = currencyExchangeRepository.findByFromAndTo(from,to);
        if(exchange != null){
        	String id = exchange.getId();
        	currencyExchangeRepository.delete(exchange);
            return id;
        }
        return "-1";
    }
	
}
