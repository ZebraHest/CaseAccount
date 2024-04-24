package com.malteneve.caseaccount.returnData;

import java.util.List;

public class AccountListReturnData extends ReturnData {
    List<AccountReturnData> list;

    public AccountListReturnData(String message, List<AccountReturnData> list) {
        super(message);
        this.list = list;
    }

    public List<AccountReturnData> getList() {
        return list;
    }
}
