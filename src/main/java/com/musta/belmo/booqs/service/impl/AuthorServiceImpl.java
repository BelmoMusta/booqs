package com.musta.belmo.booqs.service.impl;

import com.musta.belmo.booqs.entite.Author;
import com.musta.belmo.booqs.entite.dto.AuthorDTO;
import com.musta.belmo.booqs.repository.AuthorRepository;
import com.musta.belmo.booqs.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl extends AbstractService implements AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public AuthorDTO create(AuthorDTO authorDTO) {
		return applyFunctionOn(authorDTO, authorRepository::save);
	}
	
	@Override
	public Optional<AuthorDTO> findOne(Long id) {
		return authorRepository.findById(id)
				.map(toDTO());
	}
	
	@Override
	public Set<AuthorDTO> findAll() {
		return authorRepository.findAll()
				.stream()
				.map(toDTO())
				.collect(Collectors.toSet());
	}
	
	@Override
	public AuthorDTO update(AuthorDTO authorDTO) {
		return applyFunctionOn(authorDTO, authorRepository::saveAndFlush);
	}
	
	@Override
	public AuthorDTO update(Long id, AuthorDTO authorDTO) {
		return authorRepository.findById(id)
				.map(aBook -> {
					aBook.setId(id);
					return aBook;
				})
				.map(authorRepository::saveAndFlush)
				.map(toDTO())
				.orElse(authorDTO);
		
	}
	
	@Override
	public void delete(AuthorDTO authorDTO) {
	
	}
	
	@Override
	public void delete(Long id) {
	
	}
	
	
	private Function<AuthorDTO, Author> mapToEntity() {
		return entityMapper::mapToEntity;
	}
	
	private Function<Author, AuthorDTO> toDTO() {
		return entityMapper::mapToDTO;
	}
	
	private AuthorDTO applyFunctionOn(AuthorDTO authorDTO, UnaryOperator<Author> operator) {
		return mapToEntity()
				.andThen(operator
						.andThen(toDTO()))
				.apply(authorDTO);
	}
}
