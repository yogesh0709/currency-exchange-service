package com.in28minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;


@Document("currencyexchange")
public class CurrencyExchange {
	
	private String recordId;
	
	private String from;
	
	private String to;

	private BigDecimal conversionMultiple;
	private String environment;

	public CurrencyExchange() {
		
	}
	
	public CurrencyExchange(String recordId, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.recordId = recordId;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	
	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return "CurrencyExchange [recordId=" + recordId + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", environment=" + environment + "]";
	}
	
	
}
