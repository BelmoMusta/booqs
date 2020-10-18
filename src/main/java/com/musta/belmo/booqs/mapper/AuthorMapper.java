package com.musta.belmo.booqs.mapper;

import com.musta.belmo.booqs.entite.Author;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class AuthorMapper {
	public Long mapAuthorId(Author author){
		return Optional.ofNullable(author)
				.map(Author::getId)
				.orElse(null);
	}
}
