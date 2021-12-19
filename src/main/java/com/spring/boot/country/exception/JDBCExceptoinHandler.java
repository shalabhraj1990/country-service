package com.spring.boot.country.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import msk.spring.boot.common.dto.ErrorDetails;
import msk.spring.boot.common.dto.Response;

@ControllerAdvice
public class JDBCExceptoinHandler {
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Response<ErrorDetails>> handleEmptyResultDataAccessException(
			EmptyResultDataAccessException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.<ErrorDetails>builder()
				.data(ErrorDetails.builder().code(2001).message("result not found!!").build()).build());

	}

	@ExceptionHandler(IncorrectResultSizeDataAccessException.class)
	public ResponseEntity<Response<ErrorDetails>> handleIncorrectResultSizeDataAccessException(
			IncorrectResultSizeDataAccessException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.<ErrorDetails>builder()
				.data(ErrorDetails.builder().code(2002).message("mutiple result found!!").build()).build());

	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<Response<ErrorDetails>> handleThrowable(Throwable ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.<ErrorDetails>builder()
				.data(ErrorDetails.builder().code(2002).message(ex.getMessage()).build()).build());

	}
}
