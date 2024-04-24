package com.malteneve.caseaccount.returnData;

public class TransferReturnData extends ReturnData {

    private final String uid;
    private final String fromId;
    private final String toId;
    private final Double amount;

    public TransferReturnData(String message, String uid, String fromId, String toId, Double amount) {
        super(message);
        this.uid = uid;
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
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
}
