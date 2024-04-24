package com.malteneve.caseaccount.controller;

import com.malteneve.caseaccount.handlers.CreateAccountHandler;
import com.malteneve.caseaccount.handlers.ListAccountHandler;
import com.malteneve.caseaccount.handlers.TransferHandler;
import com.malteneve.caseaccount.requestData.CreateData;
import com.malteneve.caseaccount.requestData.RequestData;
import com.malteneve.caseaccount.requestData.TransferData;
import com.malteneve.caseaccount.returnData.ReturnData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final CreateAccountHandler createHandler = new CreateAccountHandler();
    private final ListAccountHandler listHandler = new ListAccountHandler();
    private final TransferHandler transferHandler = new TransferHandler();

    @GetMapping("/create")
    public ReturnData createAccount(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "amount", defaultValue = "0") Double amount) {

        CreateData data = new CreateData(name, amount);
        return createHandler.handle(data);
    }

    @GetMapping("/list")
    public ReturnData listAccounts() {
        return listHandler.handle(new RequestData());
    }

    @GetMapping("/transfer")
    public ReturnData transferAmount(
            @RequestParam(value = "fromId") String fromId,
            @RequestParam(value = "toId") String toId,
            @RequestParam(value = "amount") Double amount) {

        TransferData data = new TransferData(fromId, toId, amount);
        return transferHandler.handle(data);
    }
}
