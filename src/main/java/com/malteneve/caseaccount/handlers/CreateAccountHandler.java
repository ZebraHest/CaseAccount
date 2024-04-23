package com.malteneve.caseaccount.handlers;

import com.malteneve.caseaccount.databaseish.Databaseish;
import com.malteneve.caseaccount.domain.Account;
import com.malteneve.caseaccount.requestData.CreateData;
import com.malteneve.caseaccount.returnData.CreateAccountReturnData;
import com.malteneve.caseaccount.returnData.ReturnData;

public class CreateAccountHandler extends Handler<CreateData, ReturnData> {
    @Override
    protected void simpleValidation(CreateData data) throws ValidationException {
        isNotNull(data);
        isNotNull(data.getId());
        isNotNull(data.getAmount());
        isPositive(data.getAmount());

    }

    @Override
    protected void complexValidation(CreateData data) throws ValidationException{

    }

    @Override
    protected ReturnData handleRequest(CreateData data) {
        Account account = new Account(data.getId(), data.getAmount());
        Databaseish.addAccount(account);
        return new CreateAccountReturnData("Account created", account.getUid(), account.getId(), account.getAmount());
    }
}
