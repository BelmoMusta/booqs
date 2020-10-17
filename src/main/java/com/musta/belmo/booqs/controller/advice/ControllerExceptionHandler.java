package com.musta.belmo.booqs.controller.advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
 
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<ErrorWrapper> handleOthers(Exception e) {
		logger.error("Error : ", e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ErrorEnum.INTERNAL_SERVER_ERROR.getErrorWrapper());
	}
	
	@ExceptionHandler(value = {DataIntegrityViolationException.class})
	public ResponseEntity<ErrorWrapper> handleOthers(DataIntegrityViolationException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ErrorEnum.DATA_INTEGRITY_ERROR.getErrorWrapper());
	}
}
