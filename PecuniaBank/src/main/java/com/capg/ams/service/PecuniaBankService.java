/******************************************
 - File Name      : PecuniaBankServiceImpl.java
 - Author           : Capgemini
 - Creation Date    : 21-09-2020
 - Description      : This PecuniaBankServiceImpl used for the logic.
  ******************************************/

package com.capg.ams.service;

import java.util.List;
import java.util.Random;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ams.exception.AccountAlreadyExistException;
import com.capg.ams.exception.EmptyAccountListException;
import com.capg.ams.model.BankAccountDetails;
import com.capg.ams.model.CustomerAddress;
import com.capg.ams.repository.PecuniaBankRepo;


@Service
public class PecuniaBankService implements IPecuniaBankService {
	@Autowired
	PecuniaBankRepo accountRepo;

	/**
	* Adding BankAccount Details
	*/
	public BankAccountDetails addAccount(BankAccountDetails accDetails) throws Exception {
		accDetails.setAccNumber(Long.parseLong(String.valueOf(Math.abs(new Random().nextLong())).substring(0, 12)));
		if (accountRepo.existsById(accDetails.getAccNumber()))
			throw new AccountAlreadyExistException(
					"Customer with Name: " + accDetails.getAccNumber() + " is Already Exist");
		return accountRepo.save(accDetails);
	}

	/**
	* Updating BankAccount Details
	*/

	public BankAccountDetails updateAccount(BankAccountDetails accDetails) throws AccountNotFoundException {
		long accNo = accDetails.getAccNumber();

		BankAccountDetails accountDetails = accountRepo.getOne(accNo);
		if (accountDetails == null) {
			throw new AccountNotFoundException("account not found");
		} else {

			accountDetails.setCustomerName(accDetails.getCustomerName());

			accountDetails.setCustomerPhno(accDetails.getCustomerPhno());
			accountDetails.setCustomerAddress(accDetails.getCustomerAddress());
		}

		return accountRepo.save(accountDetails);
	}

	/**
	* Deleting BankAccount Details
	*/
	public void deleteAccount(long accNumber) throws Exception {
		if (!accountRepo.existsById(accNumber))
			throw new AccountNotFoundException("Customer with Id " + accNumber + " Not Found");

		if (accountRepo.existsById(accNumber)) {
			accountRepo.deleteById(accNumber);
		}
	}

	/**
	* Fetching BankAccount Details
	*/
	public List<BankAccountDetails> getAllAccounts() throws Exception {
		if (accountRepo.count() == 0)
			throw new EmptyAccountListException("No Account Found in Account Database");

		return accountRepo.findAll();
	}

	/**
	* Adding BankAccount Details By Id
	*/
	public BankAccountDetails getById(Long accNumber) throws AccountNotFoundException {
		if (!accountRepo.existsById(accNumber))
			throw new AccountNotFoundException("Customer with Id " + accNumber + " Not Found");
		return accountRepo.getOne(accNumber);

	}
}
