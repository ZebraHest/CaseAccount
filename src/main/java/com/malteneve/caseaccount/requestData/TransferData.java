package com.malteneve.caseaccount.requestData;

public class TransferData extends RequestData {
    private final String fromId;
    private final String toId;
    private final Double amount;

    public TransferData(String fromId, String toId, Double amount) {
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
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
}
