package com.malteneve.caseaccount.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Account {

	private String uid;
	private String id;
	private Double amount;
	private LocalDateTime dateTime;


	public Account(String id, Double amount) {
		this.uid = UUID.randomUUID().toString();
		this.id = id;
		this.amount = amount;
		this.dateTime = LocalDateTime.now();
	}

	public String getUid() {
		return uid;
	}

	public String getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public Double addToAmount(Double addAmount){
		this.amount += addAmount;
		return this.amount;
	}
}
