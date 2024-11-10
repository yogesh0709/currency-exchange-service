package com.in28minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchangeRate {
	
	@Id
	private Long id;
	
	@Column(name = "exchange_rate_from")
	private String from;
	
	@Column(name = "exchange_rate_to")
	private String to;
	
	@Column(name = "exchange_rate")
	private BigDecimal rate;
	
	@Column(name = "effective_date")
	private Date effectiveDate;

	public CurrencyExchangeRate() {
		
	}
	
	public CurrencyExchangeRate(Long id,String from,String to, BigDecimal rate, Date effectiveDate) {
		super();
		this.id=id;
		this.from = from;
		this.to = to;
		this.rate = rate;
		this.effectiveDate = effectiveDate;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	
}
