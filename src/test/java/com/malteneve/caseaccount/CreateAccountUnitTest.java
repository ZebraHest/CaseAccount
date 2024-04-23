package com.malteneve.caseaccount;

import com.malteneve.caseaccount.requestData.CreateData;
import com.malteneve.caseaccount.returnData.CreateAccountReturnData;
import com.malteneve.caseaccount.returnData.ErrorReturnData;
import com.malteneve.caseaccount.returnData.ReturnData;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAccountUnitTest extends UnitTest{

    @Test
    void createAccountTest(){
        CreateAccountReturnData returnData = (CreateAccountReturnData) createAccount("test1", 200.);
        assertThat(returnData.getId()).isEqualTo("test1");
        assertThat(returnData.getAmount()).isEqualTo(200.);
    }

    @Test
    void createAccountNegativeAmountTest(){
        ReturnData returnData = createAccount("test2", -200.);
        assertThat(returnData).isExactlyInstanceOf(ErrorReturnData.class);
    }

    @Test
    void createAccountNullIdTest(){
        CreateData data= new CreateData(null, 200.);
        ReturnData returnData = createHandler.handle(data);
        assertThat(returnData).isExactlyInstanceOf(ErrorReturnData.class);
        assertThat(returnData.getMessage()).matches(s -> s.contains("not be null"));
    }

}
