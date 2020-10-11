package com.musta.belmo.booqs.entite;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@Hidden
public class Author extends AbstractEntity {
	private String firstName;
	private String middleName;
	private String lastName;
	
}
