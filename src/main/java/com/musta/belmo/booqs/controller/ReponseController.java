package com.musta.belmo.booqs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class ReponseController {
	
	protected <T> ResponseEntity<T> okAsResponseWithBody(T body) {
		return ResponseEntity.ok()
				.body(body);
	}
	
	protected <T> ResponseEntity<T> notFound() {
		return ResponseEntity.notFound().build();
	}
	
	protected <T> ResponseEntity<T> badRequest() {
		return ResponseEntity.badRequest().build();
	}
	protected <T> ResponseEntity<T> returnStatus(int status) {
		return ResponseEntity.status(status).build();
	}
	protected <T> ResponseEntity<T> returnStatus(HttpStatus status) {
		return ResponseEntity.status(status).build();
	}
}
