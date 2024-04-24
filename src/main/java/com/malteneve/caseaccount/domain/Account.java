package com.malteneve.caseaccount.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Account {

    private final String uid;
    private final String id;
    private final LocalDateTime dateTime;
    private Double amount;


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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void addToAmount(Double addAmount) {
        this.amount += addAmount;
    }
}
