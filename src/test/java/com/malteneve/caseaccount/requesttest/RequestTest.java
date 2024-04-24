package com.malteneve.caseaccount.requesttest;

import com.malteneve.caseaccount.returnData.AccountListReturnData;
import com.malteneve.caseaccount.returnData.AccountReturnData;
import com.malteneve.caseaccount.returnData.TransferReturnData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testAPI() {
        //Create Accounts
        AccountReturnData data1 = this.restTemplate.getForObject(
                "http://localhost:" + port + "/create?name=testapi1",
                AccountReturnData.class);

        assertThat(data1.getId()).isEqualTo("testapi1");
        assertThat(data1.getAmount()).isEqualTo(0.);

        AccountReturnData data2 = this.restTemplate.getForObject(
                "http://localhost:" + port + "/create?name=testapi2&amount=2000",
                AccountReturnData.class);

        assertThat(data2.getId()).isEqualTo("testapi2");
        assertThat(data2.getAmount()).isEqualTo(2000.);

        //Get list of accounts

        AccountListReturnData dataList = this.restTemplate.getForObject("http://localhost:" + port + "/list",
                AccountListReturnData.class);

        AccountReturnData toAccount = dataList.getList()
                .stream()
                .filter(a -> "testapi1".equals(a.getId()))
                .findAny()
                .get();

        AccountReturnData fromAccount = dataList.getList()
                .stream()
                .filter(a -> "testapi2".equals(a.getId()))
                .findAny()
                .get();

        String toUid = toAccount.getUid();
        String fromUid = fromAccount.getUid();

        // Transfer

        TransferReturnData dataTransfer = this.restTemplate.getForObject(
                "http://localhost:" + port + "/transfer?fromId=" + fromUid + "&toId=" + toUid + "&amount=500",
                TransferReturnData.class);


        assertThat(dataTransfer.getUid()).isNotNull();
        //Get list again

        AccountListReturnData dataListAfter = this.restTemplate.getForObject(
                "http://localhost:" + port + "/list",
                AccountListReturnData.class);

        toAccount = dataListAfter.getList()
                .stream()
                .filter(a -> "testapi1".equals(a.getId()))
                .findAny()
                .get();

        fromAccount = dataListAfter.getList()
                .stream()
                .filter(a -> "testapi2".equals(a.getId()))
                .findAny()
                .get();

        assertThat(fromAccount.getAmount()).isEqualTo(1500);
        assertThat(toAccount.getAmount()).isEqualTo(500);

    }


}
