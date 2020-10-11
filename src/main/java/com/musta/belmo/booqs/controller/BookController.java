package com.musta.belmo.booqs.controller;

import com.musta.belmo.booqs.entite.dto.BookDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Set;

@RestController
@RequestMapping(value = "/book", consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
	@GetMapping
	public ResponseEntity<Set<BookDTO>> all() {
		return ResponseEntity.ok().body(Collections.emptySet());
	}
}
