package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository 
	extends JpaRepository<CurrencyExchangeRate, Long> {
	CurrencyExchangeRate findByFromAndTo(String from, String to);
}
