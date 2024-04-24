package com.malteneve.caseaccount.datamanager;

import com.malteneve.caseaccount.domain.Account;
import com.malteneve.caseaccount.domain.Transfer;

import java.util.HashMap;
import java.util.List;

public class DataManager {

    static HashMap<String, Account> accountMap = new HashMap<>();
    static HashMap<String, Transfer> transferMap = new HashMap<>();

    static public void addAccount(Account account) {
        String id = account.getUid();
        accountMap.put(id, account);
    }

    static public void addTransfer(Transfer transfer) {
        String id = transfer.getUid();
        transferMap.put(id, transfer);
    }

    static public Account getAccount(String id) {
        return accountMap.get(id);
    }

    static public List<Account> getAccounts() {
        return accountMap.values().stream().toList();
    }

    public static HashMap<String, Transfer> getTransferMap() {
        return transferMap;
    }
}
