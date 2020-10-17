package com.musta.belmo.booqs.controller.author;

import com.musta.belmo.booqs.controller.annotation.BasicOpenAPIAnnotations;
import com.musta.belmo.booqs.entite.dto.AuthorDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController extends AuthorBaseController {
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@BasicOpenAPIAnnotations
	@Operation(summary = "Lists all the authors")
	public ResponseEntity<Set<AuthorDTO>> all() {
		return okAsResponseWithBody(authorService.findAll());
	}
	
	@PostMapping
	@BasicOpenAPIAnnotations
	@Operation(summary = "Creates an author")
	public ResponseEntity<AuthorDTO> create(@RequestBody AuthorDTO authorDTO) {
		final AuthorDTO createdBook = authorService.create(authorDTO);
		return okAsResponseWithBody(createdBook);
	}
}
