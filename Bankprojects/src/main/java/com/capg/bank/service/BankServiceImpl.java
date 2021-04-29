package com.capg.bank.service;

import com.capg.bank.dao.bankDao;
import com.capg.bank.dao.bankDaoImpl;
import com.capg.bank.model.Account;

public class BankServiceImpl implements IBankService {

	private bankDao dao= new bankDaoImpl();
	//@Override
	public void addAccountDetails(Account account) {
		
		dao.addAccountDetails(account);
	}

	//@Override
	public Account getAccountByAccountNumber(Integer accountnumber) {
		return dao.getAccountByAccountNumber(accountnumber);
	}

}
