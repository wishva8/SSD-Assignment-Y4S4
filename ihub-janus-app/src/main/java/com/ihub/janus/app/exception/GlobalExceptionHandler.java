package com.ihub.janus.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class, Exception.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {

		ErrorResponse errorDetails = new ErrorResponse(new Date(), "Internal Server Error", ex.getMessage());
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);

	}
}