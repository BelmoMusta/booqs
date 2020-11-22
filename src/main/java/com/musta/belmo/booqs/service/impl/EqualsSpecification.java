package com.musta.belmo.booqs.service.impl;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EqualsSpecification<T> implements Specification<T> {
	final String field;
	final Object value;
	
	public EqualsSpecification(String field, Object value) {
		this.field = field;
		this.value = value;
	}
	
	
	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery,
								 CriteriaBuilder criteriaBuilder) {
		return criteriaBuilder.equal(root.get(field), value);
		
	}
}
