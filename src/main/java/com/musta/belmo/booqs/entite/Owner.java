package com.musta.belmo.booqs.entite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter

public class Owner extends AbstractEntity {
	private String name;
	private String lastName;
	private String address;
	@OneToMany(mappedBy = "owner")
	private Set<Book> books;
	
}
