package com.malteneve.caseaccount.returnData;

import com.malteneve.caseaccount.domain.Account;

import java.time.LocalDateTime;

public class AccountReturnData extends ReturnData {

    private String uid;
    private String id;
    private Double amount;
    private LocalDateTime dateTime;

    public AccountReturnData(String message) {
        super(message);
    }

    public AccountReturnData(String message, Account account) {
        super(message);
        this.uid = account.getUid();
        this.id = account.getId();
        this.amount = account.getAmount();
        this.dateTime = account.getDateTime();
    }

    public AccountReturnData(Account account) {
        this("", account);
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
