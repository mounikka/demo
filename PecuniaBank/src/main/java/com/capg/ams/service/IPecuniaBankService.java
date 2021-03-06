package com.capg.ams.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.capg.ams.model.BankAccountDetails;

public interface IPecuniaBankService {
	public BankAccountDetails addAccount(BankAccountDetails accDetails) throws AccountNotFoundException, Exception;
	public BankAccountDetails updateAccount(BankAccountDetails accDetails) throws AccountNotFoundException;
	public void deleteAccount(long accNumber) throws AccountNotFoundException, Exception;
	public List<BankAccountDetails> getAllAccounts() throws Exception;

}
