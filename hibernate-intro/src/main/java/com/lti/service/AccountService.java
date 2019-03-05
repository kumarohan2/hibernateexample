package com.lti.service;



import java.util.Date;

import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.Statement;

public class AccountService {
	GenericDao dao=new GenericDao();
	public void openAccount(String name, String type, double initialBalance) {
		Account a= new Account();
	
			a.setName(name);
			a.setType(type);
			a.setBalance(initialBalance);
			
			
			dao.merge(a);
		}
	

	public void withdraw(long acno, double amount) {
	Account a=dao.fetch(Account.class,acno);
	a.setBalance(a.getBalance()-amount);
	

		Statement sm= new Statement();
		Date d= new Date();
		sm.setDate(d);
		sm.setType("withdraw");
		sm.setAmount(amount);
		sm.setAccount(a);
		
		
		dao.merge(sm);
		dao.merge(a);
		
		
	}

	

	public void deposit(long acno, double amount) {
		Account a =dao.fetch(Account.class, acno);
		Date d = new Date();
		Statement sm= new Statement();
		sm.setDate(d);
		sm.setType("deposit");
		sm.setAmount(amount);
		sm.setAccount(a);
		a.setBalance(a.getBalance() + amount);
		dao.merge(sm);
		dao.merge(a);
		

	}

	public void transfer(long fromacno, long toacno, double amount) {
		
		Account a1=dao.fetch(Account.class, toacno);
		Account a2=dao.fetch(Account.class, fromacno);
		if(amount<(a2.getBalance()-1000)) {
			a1.setBalance(a1.getBalance()+amount);
			a2.setBalance(a2.getBalance()+amount);
			
			Date d= new Date();
			Statement sm= new Statement();
			sm.setDate(d);
			sm.setType("transer");
			sm.setAmount(amount);
			sm.setAccount(a1);
		
			Statement sm1= new Statement();
			sm1.setDate(d);
			sm1.setType("withdraw");
			sm1.setAmount(amount);
			sm1.setAccount(a2);
			
			dao.merge(sm);
			dao.merge(sm1);
			dao.merge(a1);
			dao.merge(a2);
		
		}
	} 

	public double checkBalance(long acno) {
		Account a=dao.fetch(Account.class, acno);
		return a.getBalance();
	}
}
