package com.malteneve.caseaccount.unittest;

import com.malteneve.caseaccount.datamanager.DataManager;
import com.malteneve.caseaccount.requestData.TransferData;
import com.malteneve.caseaccount.returnData.AccountReturnData;
import com.malteneve.caseaccount.returnData.ErrorReturnData;
import com.malteneve.caseaccount.returnData.ReturnData;
import com.malteneve.caseaccount.returnData.TransferReturnData;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransferUnitTest extends UnitTest {

    @Test
    void transferTest() {
        AccountReturnData fromData = (AccountReturnData) createAccount("testFrom1", 2000.);
        AccountReturnData toData = (AccountReturnData) createAccount("testTo1", 2000.);

        String fromUid = fromData.getUid();
        String toUid = toData.getUid();

        TransferData transferData = new TransferData(fromUid, toUid, 500.);
        TransferReturnData returnData = (TransferReturnData) transferHandler.handle(transferData);

        Double amountFromAfter = DataManager.getAccount(fromUid).getAmount();
        Double amountToAfter = DataManager.getAccount(toUid).getAmount();

        assertThat(amountFromAfter).isEqualTo(1500.);
        assertThat(amountToAfter).isEqualTo(2500.);
    }

    @Test
    void transferToMuchMoneyTest() {
        AccountReturnData fromData = (AccountReturnData) createAccount("testFrom1", 2000.);
        AccountReturnData toData = (AccountReturnData) createAccount("testTo1", 2000.);

        String fromUid = fromData.getUid();
        String toUid = toData.getUid();

        TransferData transferData = new TransferData(fromUid, toUid, 5000.);
        ReturnData returnData = transferHandler.handle(transferData);

        assertThat(returnData).isExactlyInstanceOf(ErrorReturnData.class);
        assertThat(returnData.getMessage()).matches(s -> s.contains("Expected 5000.0 but found only 2000.0"));

    }
}
