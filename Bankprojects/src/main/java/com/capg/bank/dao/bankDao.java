package com.capg.bank.dao;

import com.capg.bank.model.Account;

public interface bankDao {
	void addAccountDetails(Account account);
	Account getAccountByAccountNumber(Integer accountnumber);

}
