package com.cognizant.loan.controller;

import java.util.List;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.loan.feignclient.AccountFeignClientIntf;
import com.cognizant.loan.model.Account;
import com.cognizant.loan.model.Loan;
import com.cognizant.loan.service.LoanService;

@RestController
//@RequestMapping("/loan")
public class LoanController {
		@Autowired
		LoanService loanService ;
//		@Autowired
//		RestTemplate restTemplate;
		@GetMapping("/alldata")
		public ResponseEntity<List<Loan>> getAllLoan()
		{
			List<Loan> details = loanService.getDetails();
			return new ResponseEntity<List<Loan>>(details,HttpStatus.OK); 
		}
		@Autowired
		AccountFeignClientIntf accountFeignClientIntf;
		/* getting the data from account microservice using feign client */
		@GetMapping("/accdata")
		public ResponseEntity<Account> getLoanData()
		{
			 return accountFeignClientIntf.getAccount();
		
		}
		@GetMapping("/discoveryaccount")
		public ResponseEntity<Account> getDataUsingDisvoery()
		{
			ResponseEntity<Account> accountUsingDiscovery = loanService.getAccountUsingDiscovery();
			return accountUsingDiscovery;
		}
		
		@GetMapping("/accloandbalancer")
		public ResponseEntity<Account> getDataUsingLoandBalancer()
		{
			ResponseEntity<Account> usingLoadBalancer = loanService.usingLoadBalancer();
			return usingLoadBalancer;
		}
		
}
