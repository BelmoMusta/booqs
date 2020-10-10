package com.musta.belmo.booqs.booqs.entite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class Book extends AbstractEntity {
	private String title;
	private String isbn;
	private String author;
	private int year;
	
}
