package com.malteneve.caseaccount;

import com.malteneve.caseaccount.databaseish.Databaseish;
import com.malteneve.caseaccount.requestData.TransferData;
import com.malteneve.caseaccount.returnData.CreateAccountReturnData;
import com.malteneve.caseaccount.returnData.ErrorReturnData;
import com.malteneve.caseaccount.returnData.ReturnData;
import com.malteneve.caseaccount.returnData.TransferReturnData;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransferUnitTest extends UnitTest{

    @Test
    void transferTest(){
        CreateAccountReturnData fromData = (CreateAccountReturnData) createAccount("testFrom1", 2000.);
        CreateAccountReturnData toData = (CreateAccountReturnData) createAccount("testTo1", 2000.);

        String fromUid = fromData.getUid();
        String toUid = toData.getUid();

        TransferData transferData = new TransferData(fromUid, toUid, 500.);
        TransferReturnData returnData = (TransferReturnData) transferHandler.handle(transferData);

        Double amountFromAfter = Databaseish.getAccount(fromUid).getAmount();
        Double amountToAfter = Databaseish.getAccount(toUid).getAmount();

        assertThat(amountFromAfter).isEqualTo(1500.);
        assertThat(amountToAfter).isEqualTo(2500.);
    }

    @Test
    void transferToMuchMoneyTest(){
        CreateAccountReturnData fromData = (CreateAccountReturnData) createAccount("testFrom1", 2000.);
        CreateAccountReturnData toData = (CreateAccountReturnData) createAccount("testTo1", 2000.);

        String fromUid = fromData.getUid();
        String toUid = toData.getUid();

        TransferData transferData = new TransferData(fromUid, toUid, 5000.);
        ReturnData returnData =  transferHandler.handle(transferData);

        assertThat(returnData).isExactlyInstanceOf(ErrorReturnData.class);
        assertThat(returnData.getMessage()).matches(s -> s.contains("Expected 5000.0 but found only 2000.0"));

    }
}
