package com.musta.belmo.booqs.entite.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookDTO {
	private Long id;
	private String title;
	private String isbn;
	private AuthorDTO author;
	private Integer year;
	private BigDecimal price;
	private String contentAbstract;
	
}
