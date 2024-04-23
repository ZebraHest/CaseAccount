package com.malteneve.caseaccount;

import com.malteneve.caseaccount.domain.Account;
import com.malteneve.caseaccount.returnData.ReturnData;
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
	void greetingShouldReturnDefaultMessage() throws Exception {
		ReturnData data = this.restTemplate.getForObject("http://localhost:" + port + "/create?name=test",
				ReturnData.class);
		assertThat(data.getMessage()).matches(s -> s.contains("test"));
		assertThat(data.getMessage()).matches(s -> s.contains(": 0"));
	}
}
