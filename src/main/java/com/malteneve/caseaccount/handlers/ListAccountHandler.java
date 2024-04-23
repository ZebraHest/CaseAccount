package com.malteneve.caseaccount.handlers;

import com.malteneve.caseaccount.databaseish.Databaseish;
import com.malteneve.caseaccount.domain.Account;
import com.malteneve.caseaccount.requestData.RequestData;
import com.malteneve.caseaccount.returnData.AccountListReturnData;
import com.malteneve.caseaccount.returnData.ReturnData;

import java.util.List;

public class ListAccountHandler extends Handler<RequestData, ReturnData> {
    @Override
    protected void simpleValidation(RequestData data) throws ValidationException {
    }

    @Override
    protected void complexValidation(RequestData data) throws ValidationException{

    }

    @Override
    protected ReturnData handleRequest(RequestData data) {
        List<Account> accounts = Databaseish.getAccounts();
        return new AccountListReturnData("List of Accounts", accounts);
    }
}
