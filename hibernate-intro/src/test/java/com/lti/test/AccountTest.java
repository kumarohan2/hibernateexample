package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.service.AccountService;

public class AccountTest {

	@Test
	public void addAccount() {
		AccountService ser=new AccountService();
		ser.openAccount("sid", "Current", 5000);
	}

	@Test
	public void deposit() {
		AccountService ser=new AccountService();
		ser.deposit(281, 2000);
	}
	
	@Test
	public void withdraw() {
		AccountService ser=new AccountService();
		ser.withdraw(281,1000);
		
	}
	@Test
	public void transfer() {
		AccountService ser=new AccountService();
		ser.transfer(281, 300,1000);
	}
	
}
