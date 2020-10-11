package com.musta.belmo.booqs.controller;

import com.musta.belmo.booqs.entite.dto.BookDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;

@Target({METHOD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)


@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Found the book",
				content = { @Content(mediaType = "application/json",
						schema = @Schema(implementation = BookDTO.class)) }),
		@ApiResponse(responseCode = "400", description = "Invalid id supplied",
				content = @Content),
		@ApiResponse(responseCode = "404", description = "Book not found",
				content = @Content) })
public @interface BookAnnotation {
}
