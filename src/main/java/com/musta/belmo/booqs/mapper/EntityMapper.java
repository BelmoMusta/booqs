package com.musta.belmo.booqs.mapper;

import com.musta.belmo.booqs.entite.Author;
import com.musta.belmo.booqs.entite.Book;
import com.musta.belmo.booqs.entite.dto.AuthorDTO;
import com.musta.belmo.booqs.entite.dto.BookDTO;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIoC = IoC.SPRING,
		ignoreNotSupported = true,
		withIgnoreMissing = IgnoreMissing.ALL,
		withIgnoreNullValue = true, withCustom = AuthorMapper.class)

public interface EntityMapper {
	BookDTO mapToDTO(Book book);
	Book mapToEntity(BookDTO book);
	AuthorDTO mapToDTO(Author book);
	Author mapToEntity(AuthorDTO book);
}
