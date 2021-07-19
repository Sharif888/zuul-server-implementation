package com.cognizant.accountapp.model;

public class Account {
		String number;
		String type;
		int balance;
		public Account() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Account(String number, String type, int balance) {
			super();
			this.number = number;
			this.type = type;
			this.balance = balance;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getBalance() {
			return balance;
		}
		public void setBalance(int balance) {
			this.balance = balance;
		}
		
		
}
