package com.malteneve.caseaccount;

import com.malteneve.caseaccount.domain.Account;
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
		Account account = this.restTemplate.getForObject("http://localhost:" + port + "/create?name=test",
				Account.class);
		assertThat(account.getId()).isEqualTo("test");
		assertThat(account.getAmount()).isEqualTo(0.);
	}
}
