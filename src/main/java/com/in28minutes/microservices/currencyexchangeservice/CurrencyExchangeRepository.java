package com.in28minutes.microservices.currencyexchangeservice;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CurrencyExchangeRepository extends MongoRepository<CurrencyExchange, Long> {
	CurrencyExchange findByFromAndTo(String from, String to);
	List<CurrencyExchange> findAll();
}
