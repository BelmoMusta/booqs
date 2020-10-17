package com.musta.belmo.booqs.entite;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter
@Hidden
public class Author extends AbstractEntity {
	private String firstName;
	private String middleName;
	private String lastName;
	
	@OneToMany(mappedBy = "author")
	private Set<Book> books;
	
	@Override
	public boolean equals(Object o) {
		final boolean areEqual;
		if (this == o) {
			areEqual = true;
		} else if (o == null || getClass() != o.getClass()) {
			areEqual = false;
		} else if (!super.equals(o)) {
			areEqual = false;
		} else {
			final Author otherAuthor = (Author) o;
			areEqual = Objects.equals(getId(), otherAuthor.getId());
		}
		return areEqual;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId());
	}
}
