package com.malteneve.caseaccount.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transfer {
    private String uid;
    private String fromId;
    private String toId;
    private Double amount;
    private LocalDateTime dateTime;


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
