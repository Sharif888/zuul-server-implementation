package com.cognizant.accountapp.services;

import org.springframework.stereotype.Service;

import com.cognizant.accountapp.model.Account;

import java.util.*;
@Service
public class AccountService {
		List<Account> list = new ArrayList<Account>();
		public AccountService()
		{
			list.add(new Account("6466899","Sharif teli",7879));
			list.add(new Account("35346436","Rizwan",65876));
			list.add(new Account("w342352","shakib",587687));
		}
		public List<Account> getAllData()
		{
			return list;
		}
}
