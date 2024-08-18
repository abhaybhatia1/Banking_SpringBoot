package com.bankingapp.banking.service.impl;

import org.springframework.stereotype.Service;


import com.bankingapp.banking.AccountDTO.AccountDTo;
import com.bankingapp.banking.Mapper.AccountMapper;
import com.bankingapp.banking.entity.Account;
import com.bankingapp.banking.repository.AccountRepository;
import com.bankingapp.banking.service.AccountService;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class AccountServiceImpl implements AccountService {

	
	private AccountRepository accountRepository;
	
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}


	@Override
	public AccountDTo createAccount(AccountDTo accountDTO) {
		Account account = AccountMapper.mapToAccount(accountDTO);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}


	@Override
	public AccountDTo getAccountById(Long Id) {
		Account account = accountRepository.findById(Id).orElseThrow(()-> new RuntimeException("Account Does not exists"));
		
		return AccountMapper.mapToAccountDTO(account);
	}


	@Override
	public String deleteAccount(Long Id) {
		Account account = accountRepository.findById(Id).orElseThrow(()-> new RuntimeException("Account doesnot exists"));
		accountRepository.deleteById(Id);
		return "Account Deleted";
	}


	@Override
	public AccountDTo deposit(Long Id, double amount) {
		Account account = accountRepository.findById(Id).orElseThrow(()-> new RuntimeException("Account does not exists"));
		double updated = account.getBalance()+amount;
		account.setBalance(updated);
		accountRepository.save(account);
		return AccountMapper.mapToAccountDTO(account);
	}


	@Override
	public List<AccountDTo> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		List<AccountDTo> allAcounts = accounts.stream().map((account)-> AccountMapper.mapToAccountDTO(account)).collect(Collectors.toList());
		return allAcounts;
	}
	
	
	
	
 
}
