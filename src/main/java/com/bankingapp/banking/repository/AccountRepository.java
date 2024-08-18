package com.bankingapp.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingapp.banking.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{

}
