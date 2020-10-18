package com.musta.belmo.booqs.controller.book;

import com.musta.belmo.booqs.controller.annotation.BasicOpenAPIAnnotations;
import com.musta.belmo.booqs.entite.dto.BookDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/books")
public class BookController extends BookBaseController {
	
	@GetMapping
	@BasicOpenAPIAnnotations
	@Operation(summary = "Lists all the books")
	public ResponseEntity<Set<BookDTO>> all() {
		return okAsResponseWithBody(bookService.findAll());
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Gets a book with the given id")
	public ResponseEntity<BookDTO> get(@Parameter(description = "The id") @PathVariable Long id) {
		return bookService.findOne(id)
				.map(this::okAsResponseWithBody)
				.orElse(notFound("Book", id));
	}
	
	@PostMapping
	@BasicOpenAPIAnnotations
	@Operation(summary = "Creates a book")
	public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO) {
		final BookDTO createdBook = bookService.create(bookDTO);
		return okAsResponseWithBody(createdBook);
		
	}
}
