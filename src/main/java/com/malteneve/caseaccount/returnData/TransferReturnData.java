package com.malteneve.caseaccount.returnData;

public class TransferReturnData extends ReturnData{

    public TransferReturnData(String message) {
        super(message);
    }

    public TransferReturnData(String message, String uid, String fromId, String toId, Double amount) {
        super(message);
        this.uid = uid;
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
    }

    private String uid;
    private String fromId;
    private String toId;
    private Double amount;

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
