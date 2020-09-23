package com.capg.ams.controller;

import java.util.Date;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.ams.exception.AccountAlreadyExistException;
import com.capg.ams.exception.EmptyAccountListException;
import com.capg.ams.model.ErrorResponse;

@RestControllerAdvice
public class ErrorController {
	@ResponseStatus(code = HttpStatus.CREATED)
	@ExceptionHandler(value = { AccountAlreadyExistException.class })
	public ErrorResponse handleAccountAlreadyExistsException(Exception ex, HttpServletRequest req) {

		return new ErrorResponse(new Date(), ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				HttpStatus.BAD_REQUEST.value(), req.getRequestURL().toString());

	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@ExceptionHandler(value = { AccountNotFoundException.class })
	public ErrorResponse handleAccountNotException(Exception ex, HttpServletRequest req) {

		return new ErrorResponse(new Date(), ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				HttpStatus.BAD_REQUEST.value(), req.getRequestURL().toString());

	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { EmptyAccountListException.class })
	public ErrorResponse handleEmptyAccountException(Exception ex, HttpServletRequest req) {
		return new ErrorResponse(new Date(), ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				HttpStatus.BAD_REQUEST.ordinal(), req.getRequestURI().toString());
	}

}
