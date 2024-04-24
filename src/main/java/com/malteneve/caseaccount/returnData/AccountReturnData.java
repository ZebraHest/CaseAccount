package com.malteneve.caseaccount.returnData;

import java.time.LocalDateTime;

public class AccountReturnData extends ReturnData {

    private final String uid;
    private final String id;
    private final Double amount;
    private final LocalDateTime dateTime;

    public AccountReturnData(String message, String uid, String id, Double amount, LocalDateTime dateTime) {
        super(message);
        this.uid = uid;
        this.id = id;
        this.amount = amount;
        this.dateTime = dateTime;
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
}
