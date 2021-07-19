package com.cognizant.loan.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.cognizant.loan.model.Account;
@FeignClient(name = "${account.feng.url}")
//@FeignClient(url ="http://localhost:8091/account",name =  "account-app" )
public interface AccountFeignClientIntf {
		
//	@GetMapping("/account/ac")
		@GetMapping("/ac")
		public ResponseEntity<Account> getAccount();
		
}
