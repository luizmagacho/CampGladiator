package com.magacho.camp_gladiator_test.exception;

import br.com.escolaconquer.enrollment.exception.runtime.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class ExceptionManager {
	Logger logger = LoggerFactory.getLogger(ExceptionManager.class);

	@ExceptionHandler({HttpClientErrorException.class})
	public ResponseEntity<Response> httpClientError(Exception e, HttpServletRequest request) {
		logger.error("Http client error: "+e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new Response(HttpStatus.BAD_REQUEST, e.getMessage()));
	}

	@ExceptionHandler({BadRequestException.class})
	public ResponseEntity<Response> badRequestException(BadRequestException e, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new Response(HttpStatus.BAD_REQUEST, e.getMessage()));
	}

	@ExceptionHandler({RequiredFieldException.class})
	public ResponseEntity<Response> requiredField(RequiredFieldException e, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
				.body(new Response(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage()));
	}
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<Response> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new Response(HttpStatus.NOT_FOUND, e.getMessage()));
	}

	@ExceptionHandler(ObjectAlreadyExistsException.class)
	public ResponseEntity<Response> objectAlreadyExists(ObjectAlreadyExistsException e,
														HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new Response(HttpStatus.BAD_REQUEST, e.getMessage()));
	}

	@ExceptionHandler({TechnicalException.class})
	public ResponseEntity<Response> technicalException(TechnicalException e, HttpServletRequest request) {
		logger.error("Technical error: "+e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(
				HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
	}

	@ExceptionHandler({Exception.class})
	public ResponseEntity<Response> exception(Exception e, HttpServletRequest request) {
		logger.error("Exception: "+e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(
				HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
	}

	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<Response> exception(MethodArgumentNotValidException e, HttpServletRequest request) {
		List<String> errors = new ArrayList<>();
		e.getAllErrors().forEach(val -> {
			errors.add(val.getObjectName()+"::"+val.getDefaultMessage());
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(
				HttpStatus.BAD_REQUEST, "validation errors", new Date(), errors));
	}
}
