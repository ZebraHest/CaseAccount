package com.malteneve.caseaccount.handlers;

import com.malteneve.caseaccount.datamanager.DataManager;
import com.malteneve.caseaccount.domain.Account;
import com.malteneve.caseaccount.domain.Transfer;
import com.malteneve.caseaccount.exception.ValidationException;
import com.malteneve.caseaccount.requestData.TransferData;
import com.malteneve.caseaccount.returnData.ReturnData;
import com.malteneve.caseaccount.returnData.TransferReturnData;

public class TransferHandler extends Handler<TransferData, ReturnData> {
    @Override
    protected void simpleValidation(TransferData data) throws ValidationException {
        isNotNull(data);
        isNotNull(data.getFromId());
        isNotNull(data.getToId());
        isNotNull(data.getAmount());
        isPositive(data.getAmount());
    }

    @Override
    protected void complexValidation(TransferData data) throws ValidationException {
        accountExist(data.getFromId());
        accountExist(data.getToId());
        hasSufficientMoney(data);
    }

    private void accountExist(String id) throws ValidationException {
        if (DataManager.getAccount(id) == null) {
            throw new ValidationException("Account " + id + " does not exist.");
        }
    }

    private void hasSufficientMoney(TransferData data) throws ValidationException {
        Double amountAccount = DataManager.getAccount(data.getFromId()).getAmount();
        if (amountAccount < data.getAmount()) {
            throw new ValidationException("Account " + data.getFromId() + " does not have enough money. Expected " + data.getAmount() + " but found only " + amountAccount);
        }
    }

    @Override
    protected ReturnData handleRequest(TransferData data) {
        Transfer transfer = new Transfer(data.getFromId(), data.getToId(), data.getAmount());
        DataManager.addTransfer(transfer);

        moveAmount(transfer);

        return new TransferReturnData("Transfer Successful", transfer.getUid(), transfer.getFromId(), transfer.getToId(), transfer.getAmount());
    }

    private void moveAmount(Transfer transfer) {
        Account fromAccount = DataManager.getAccount(transfer.getFromId());
        Account toAccount = DataManager.getAccount(transfer.getToId());
        Double amount = transfer.getAmount();

        fromAccount.addToAmount(-amount);
        toAccount.addToAmount(amount);
    }
}
