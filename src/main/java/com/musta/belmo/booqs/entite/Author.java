package com.musta.belmo.booqs.entite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter

public class Author extends AbstractEntity {
	private String firstName;
	private String middleName;
	private String lastName;
	
	@OneToMany(mappedBy = "author")
	private Set<Book> Sbooks;
	
	@Override
	public boolean equals(Object another) {
		final boolean areEqual;
		if (this == another) {
			areEqual = true;
		} else if (another == null || getClass() != another.getClass()) {
			areEqual = false;
		} else if (!super.equals(another)) {
			areEqual = false;
		} else {
			final Author otherAuthor = (Author) another;
			areEqual = Objects.equals(getId(), otherAuthor.getId());
		}
		return areEqual;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId());
	}
}
