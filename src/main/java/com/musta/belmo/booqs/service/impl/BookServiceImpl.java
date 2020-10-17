package com.musta.belmo.booqs.service.impl;

import com.musta.belmo.booqs.entite.Book;
import com.musta.belmo.booqs.entite.dto.BookDTO;
import com.musta.belmo.booqs.repository.BookRepository;
import com.musta.belmo.booqs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl extends AbstractService implements BookService {
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public BookDTO create(BookDTO bookDTO) {
		return applyFunctionOn(bookDTO, bookRepository::save);
	}
	
	@Override
	public Optional<BookDTO> findOne(Long id) {
		return bookRepository.findById(id)
				.map(toDTO());
	}
	
	@Override
	public Set<BookDTO> findAll() {
		return bookRepository.findAll()
				.stream()
				.map(toDTO())
				.collect(Collectors.toSet());
	}
	
	@Override
	public BookDTO update(BookDTO bookDTO) {
		return applyFunctionOn(bookDTO, bookRepository::saveAndFlush);
	}
	
	@Override
	public BookDTO update(Long id, BookDTO bookDTO) {
		return bookRepository.findById(id)
				.map(aBook -> {
					aBook.setId(id);
					return aBook;
				})
				.map(bookRepository::saveAndFlush)
				.map(toDTO())
				.orElse(bookDTO);
		
	}
	
	@Override
	public void delete(BookDTO bookDTO) {
	
	}
	
	@Override
	public void delete(Long id) {
	
	}
	
	
	private Function<BookDTO, Book> mapToEntity() {
		return entityMapper::mapToEntity;
	}
	
	private Function<Book, BookDTO> toDTO() {
		return entityMapper::mapToDTO;
	}
	
	private BookDTO applyFunctionOn(BookDTO bookDTO, UnaryOperator<Book> operator) {
		return mapToEntity()
				.andThen(operator
						.andThen(toDTO()))
				.apply(bookDTO);
	}
}
