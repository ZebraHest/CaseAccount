package com.malteneve.caseaccount.requestData;

public class TransferData extends RequestData{
    private String fromId;
    private String toId;
    private Double amount;

    public TransferData(String fromId, String toId, Double amount) {
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
