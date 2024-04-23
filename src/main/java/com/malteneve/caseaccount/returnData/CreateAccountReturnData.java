package com.malteneve.caseaccount.returnData;

public class CreateAccountReturnData extends ReturnData{

    public CreateAccountReturnData(String message) {
        super(message);
    }

    public CreateAccountReturnData(String message, String uid, String id, Double amount) {
        super(message);
        this.uid = uid;
        this.id = id;
        this.amount = amount;
    }

    private String uid;
    private String id;
    private Double amount;

    public String getUid() {
        return uid;
    }

    public String getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }
}
