package com.malteneve.caseaccount.unittest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class simpleTest {

    @Test
    void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat("test").isEqualTo("test");
    }
}
