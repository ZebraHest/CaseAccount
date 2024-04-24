package com.malteneve.caseaccount.unittest;


import com.malteneve.caseaccount.handlers.CreateAccountHandler;
import com.malteneve.caseaccount.handlers.ListAccountHandler;
import com.malteneve.caseaccount.handlers.TransferHandler;
import com.malteneve.caseaccount.requestData.CreateData;
import com.malteneve.caseaccount.returnData.ReturnData;

public class UnitTest {

    protected final CreateAccountHandler createHandler = new CreateAccountHandler();
    protected final ListAccountHandler listHandler = new ListAccountHandler();
    protected final TransferHandler transferHandler = new TransferHandler();


    protected ReturnData createAccount(String id, Double amount) {
        CreateData data= new CreateData(id, amount);
        return createHandler.handle(data);
    }



}
