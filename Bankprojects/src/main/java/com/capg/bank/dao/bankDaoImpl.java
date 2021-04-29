package com.capg.bank.dao;


import java.util.ArrayList;
import java.util.List;

import com.capg.bank.model.Account;

public class bankDaoImpl implements bankDao{

	private List<Account> accountList = new ArrayList<Account>();
	
	public bankDaoImpl(){
		Account a1= new Account(121, 10000);
		Account a2= new Account(122, 9000);
		Account a3= new Account(123, 5000);
		accountList.add(a1);
		accountList.add(a2);
		accountList.add(a3);
	}
	
	//@Override
	public void addAccountDetails(Account account) {
		accountList.add(account);
	}

	//S@Override
	public Account getAccountByAccountNumber(Integer accountnumber) {
		Account account1= null;
		for(Account account: accountList)
		{
			if(account.getAccountNumber() == accountnumber)
			{
				account1 = account;
			}
		}
		return account1;
	}

}
