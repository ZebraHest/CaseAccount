package com.malteneve.caseaccount.domain;

public class Account {

	private String id;
	private Double amount;


	public Account(String id, Double amount) {
		this.id = id;
		this.amount = amount;
		System.out.println("Created account "+id+" with "+amount);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
