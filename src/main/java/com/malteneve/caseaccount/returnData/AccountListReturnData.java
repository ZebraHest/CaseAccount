package com.malteneve.caseaccount.returnData;

import com.malteneve.caseaccount.domain.Account;

import java.util.List;

public class AccountListReturnData extends ReturnData{
    List<Account> list;

    public AccountListReturnData(String message, List<Account> list) {
        super(message);
        this.list = list;
    }

    public List<Account> getList() {
        return list;
    }
}
