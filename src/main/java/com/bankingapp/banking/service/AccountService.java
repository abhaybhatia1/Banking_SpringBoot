package com.bankingapp.banking.service;

import java.util.List;

import com.bankingapp.banking.AccountDTO.AccountDTo;


public interface AccountService {
	AccountDTo createAccount(AccountDTo account); 
	
	AccountDTo getAccountById(Long Id);
	
	String deleteAccount(Long Id);
	
	AccountDTo deposit(Long Id, double amount);
	
	List<AccountDTo> getAllAccounts();
}
