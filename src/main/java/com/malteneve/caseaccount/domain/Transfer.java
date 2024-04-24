package com.malteneve.caseaccount.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transfer {
    private final String uid;
    private final String fromId;
    private final String toId;
    private final Double amount;
    private final LocalDateTime dateTime;


    public Transfer(String fromId, String toId, Double amount) {
        this.uid = UUID.randomUUID().toString();
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public String getUid() {
        return uid;
    }

    public String getFromId() {
        return fromId;
    }

    public String getToId() {
        return toId;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
