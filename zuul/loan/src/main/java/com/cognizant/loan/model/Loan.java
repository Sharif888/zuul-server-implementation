package com.cognizant.loan.model;

public class Loan {
		String numeber;
		String type;
		int loan;
		int emi;
		int tenture;
		
		public Loan() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Loan(String numeber, String type, int loan, int emi, int tenture) {
			super();
			this.numeber = numeber;
			this.type = type;
			this.loan = loan;
			this.emi = emi;
			this.tenture = tenture;
		}

		public String getNumeber() {
			return numeber;
		}

		public void setNumeber(String numeber) {
			this.numeber = numeber;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getLoan() {
			return loan;
		}

		public void setLoan(int loan) {
			this.loan = loan;
		}

		public int getEmi() {
			return emi;
		}

		public void setEmi(int emi) {
			this.emi = emi;
		}

		public int getTenture() {
			return tenture;
		}

		public void setTenture(int tenture) {
			this.tenture = tenture;
		}
		
		
}
