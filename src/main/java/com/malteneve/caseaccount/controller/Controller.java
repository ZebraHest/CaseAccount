package com.malteneve.caseaccount.controller;

import com.malteneve.caseaccount.domain.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/create")
	public Account createAccount(@RequestParam(value="name") String name, @RequestParam(value="amount", defaultValue = "0") Double amount) {
		return new Account(name, amount);
	}

	@GetMapping("/")
	public String helloWorld() {
		return "Hello World!";
	}
}
