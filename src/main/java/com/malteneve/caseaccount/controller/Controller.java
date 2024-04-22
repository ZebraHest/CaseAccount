package com.malteneve.caseaccount.controller;

import com.malteneve.caseaccount.domain.Account;
import com.malteneve.caseaccount.domain.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/create")
	public Account createAccount(@RequestParam(value="name") String name, @RequestParam(value="amount", defaultValue = "0") Double amount) {
		return new Account(name, amount);
	}

	@GetMapping("/goodbye")
	public Message endMessage(@RequestParam(value="name", defaultValue = "World") String name){
		return new Message(String.format("See you next time %s", name));
	}
}
