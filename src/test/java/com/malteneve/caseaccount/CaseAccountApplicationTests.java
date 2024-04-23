package com.malteneve.caseaccount;

import com.malteneve.caseaccount.controller.Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CaseAccountApplicationTests {


	@Autowired
	private Controller controller;
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}



}
