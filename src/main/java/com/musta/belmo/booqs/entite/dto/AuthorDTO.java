package com.musta.belmo.booqs.entite.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AuthorDTO {
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private Set<BookDTO> books;
	
}
