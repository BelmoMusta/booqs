package com.musta.belmo.booqs.entite;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Setter
@Getter
@Hidden
@SuppressWarnings("ALL")
public class Book extends AbstractEntity {
	private String title;
	private String isbn;
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	private Integer year;
	private BigDecimal price;
	private String contentAbstract;
	
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
			final Book book = (Book) o;
			areEqual = Objects.equals(getId(), book.getId());
		}
		return areEqual;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId());
	}
}
