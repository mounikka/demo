/******************************************
 - File Name        : PecuniaBankController.java
 - Author           : Capgemini
 - Creation Date    : 20-09-2020
 - Description      : This Controller class act as an end point to manage the entire PecuniaBankService
  ******************************************/
package com.capg.ams.controller;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ams.exception.AccountAlreadyExistException;
import com.capg.ams.exception.EmptyAccountListException;
import com.capg.ams.model.BankAccountDetails;
import com.capg.ams.model.ErrorResponse;
import com.capg.ams.service.PecuniaBankService;

import java.util.Date;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@CrossOrigin("*")
@RequestMapping("/accounts")
class PecuniaBankController {
	@Autowired
	PecuniaBankService service;
	/******************************************
    - Method Name      : addAccount
    - End Point Url    : /add
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 21-09-2020
    - Description      : adding the account information to the database.
     ******************************************/	
	
	@PostMapping("/add")
	public BankAccountDetails addAccount(@RequestBody BankAccountDetails details)  throws Exception  {
		return service.addAccount(details);
	}
	
	/******************************************
    - Method Name      : deleteAccount
    - End Point Url    : /delete/accNum/{accNum}
    -Request Method Type: DeleteMapping
    - Author           : Capgemini
    - Creation Date    : 21-09-2020
    - Description      : deleting account information from the database.
     ******************************************/	
	
	@DeleteMapping("/delete/accNum/{accNum}")
	public void deleteAccount(@PathVariable long accNum) throws Exception  {
		service.deleteAccount(accNum);
	}
	
	/******************************************
    - Method Name      : updateAccount
    - End Point Url    : /update
    -Request Method Type: PutMapping
    - Author           : Capgemini
    - Creation Date    : 21-09-2020
    - Description      : update the account information to the database.
     ******************************************/	

	@PutMapping("/update")
	public BankAccountDetails updateAccount(@RequestBody BankAccountDetails details) throws AccountNotFoundException  {
		return service.updateAccount(details);
	}
	
	/******************************************
    - Method Name      : getAllDetails
    - End Point Url    : /all
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 21-09-2020
    - Description      : getting the all account information from the database.
     ******************************************/	
	
	@GetMapping("/all")
	public List<BankAccountDetails> getAllDetails() throws Exception{
		return service.getAllAccounts();
	}
	
	/******************************************
    - Method Name      : getById
    - End Point Url    : /get/accNum/{accNumber
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 21-09-2020
    - Description      : getting the particular account information from the database
     ******************************************/
	
	@GetMapping("/get/accNum/{accNumber}")
	public BankAccountDetails getById(@PathVariable("accNumber") Long accNumber)throws AccountNotFoundException {
		return service.getById(accNumber);
		
	}

}
