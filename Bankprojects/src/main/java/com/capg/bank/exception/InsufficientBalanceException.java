package com.capg.bank.exception;

public class InsufficientBalanceException extends Exception {

	public InsufficientBalanceException(String message) {
		super(message);
	}
}
