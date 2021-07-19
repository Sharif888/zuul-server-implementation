package com.cognizant.accountapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.accountapp.model.Account;
import com.cognizant.accountapp.services.AccountService;

@RestController
//@RequestMapping("/account")
public class AccountController {
	AccountService acounAccountService = new AccountService();
	
	@GetMapping("/getall")
	public ResponseEntity<List<Account>> getAllItem()
	{
		List<Account> allData = acounAccountService.getAllData();
		return new ResponseEntity<List<Account>>(allData,HttpStatus.OK);
	}
	
	@GetMapping("/ac")
	public ResponseEntity<Account> getAccount()
	{
		Account account = new Account();
		account.setNumber("324235234");
		account.setType("Saving");
		account.setBalance(10565);
		return new ResponseEntity<Account>(account,HttpStatus.OK);
	}
	
}
