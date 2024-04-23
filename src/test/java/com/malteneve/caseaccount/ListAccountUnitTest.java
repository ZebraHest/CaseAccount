package com.malteneve.caseaccount;

import com.malteneve.caseaccount.requestData.RequestData;
import com.malteneve.caseaccount.returnData.AccountListReturnData;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListAccountUnitTest extends UnitTest{

    @Test
    void listAccountTest(){
        createAccount("testList1", 200.);
        createAccount("testList2", 200.);
        createAccount("testList3", 200.);
        createAccount("testList4", 200.);
        createAccount("testList5", 200.);

        AccountListReturnData returnData = (AccountListReturnData) listHandler.handle(new RequestData());

        assertThat(returnData.getList()).anyMatch(s -> s.getId().equals("testList1"));
        assertThat(returnData.getList()).anyMatch(s -> s.getId().equals("testList2"));
        assertThat(returnData.getList()).anyMatch(s -> s.getId().equals("testList3"));
        assertThat(returnData.getList()).anyMatch(s -> s.getId().equals("testList4"));
        assertThat(returnData.getList()).anyMatch(s -> s.getId().equals("testList5"));
    }
}
