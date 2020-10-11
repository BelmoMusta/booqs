package com.musta.belmo.booqs.entite;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@Hidden
public class Book extends AbstractEntity {
	private String title;
	private String isbn;
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	private Integer year;
}
