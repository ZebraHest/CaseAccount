package com.malteneve.caseaccount.requestData;

public class CreateData extends RequestData {

    private String id;
    private Double amount;

    public CreateData(String id, Double amount) {
        this.id = id;
        this.amount = amount;
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
