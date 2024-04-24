package com.malteneve.caseaccount.requestData;

public class CreateData extends RequestData {

    private final String id;
    private final Double amount;

    public CreateData(String id, Double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }
}
