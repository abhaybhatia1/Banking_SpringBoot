package com.bankingapp.banking.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Account {
	
	public Account() {
		super();
	}
	public Account(Long id, String accountHolderName, double balance) {
		
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String accountHolderName;
	private double balance;
}
 																																					