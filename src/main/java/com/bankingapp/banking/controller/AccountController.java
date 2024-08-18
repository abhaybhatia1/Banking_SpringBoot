package com.bankingapp.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingapp.banking.AccountDTO.AccountDTo;
import com.bankingapp.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts") 
public class AccountController {
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping
	public ResponseEntity<AccountDTo> addAccount(@RequestBody AccountDTo accountDTO){
		return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
	}	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDTo> getAccountById(@PathVariable("id") Long Id){
		AccountDTo accountDTO  = accountService.getAccountById(Id);
		return ResponseEntity.ok(accountDTO);
	}
	
	
	@DeleteMapping("/{id}")
	public String DeleteAccount(@PathVariable("id") Long Id) {
		String isDeleted = accountService.deleteAccount(Id);
		return isDeleted;
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDTo> deposit(@PathVariable("id") Long Id,@RequestBody  Map<String , Double> request) {
		AccountDTo accountDTO = accountService.deposit(Id, request.get("amount"));
		
		return ResponseEntity.ok(accountDTO);
	}
	
	
	@GetMapping
	public ResponseEntity<List<AccountDTo>> getAllAccounts() {
		List<AccountDTo> accounts = accountService.getAllAccounts();
		
		return ResponseEntity.ok(accounts);
	}
	
	
	
}
