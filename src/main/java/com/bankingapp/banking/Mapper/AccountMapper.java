package com.bankingapp.banking.Mapper;

import com.bankingapp.banking.AccountDTO.AccountDTo;
import com.bankingapp.banking.entity.Account;

public class AccountMapper {
	
	
	public static Account mapToAccount(AccountDTo accountDto) {
		Account account = new Account(
				accountDto.getId(),
				accountDto.getAccountHolderName(),
				accountDto.getBalance()
				
				);
		return account;
				
	}
	
	
	public static AccountDTo mapToAccountDTO(Account account) {
		AccountDTo accountDTO = new AccountDTo(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance()
				);
		return accountDTO;
	}
}
