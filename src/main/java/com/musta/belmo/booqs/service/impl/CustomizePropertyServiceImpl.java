package com.musta.belmo.booqs.service.impl;

import com.musta.belmo.booqs.entite.CustomizedProperty;
import com.musta.belmo.booqs.entite.QCustomizedProperty;
import com.musta.belmo.booqs.entite.dto.CustomizedPropertyDTO;
import com.musta.belmo.booqs.repository.CustomizedPropertyRepository;
import com.musta.belmo.booqs.repository.JPAQueryHolder;
import com.musta.belmo.booqs.service.CustomizePropertyService;
import com.querydsl.jpa.impl.JPADeleteClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomizePropertyServiceImpl implements CustomizePropertyService {
	@Autowired
	private CustomizedPropertyRepository customizedPropertyRepository;
	
	@Override
	public void create(CustomizedPropertyDTO propertyDTO) {
		final CustomizedProperty customizedProperty = new CustomizedProperty();
		customizedProperty.setName(propertyDTO.getName());
		customizedProperty.setType(propertyDTO.getType());
		customizedPropertyRepository.save(customizedProperty);
	}
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public void delete(String name) {
		JPADeleteClause deleteQuery = JPAQueryHolder.createDeleteQuery(QCustomizedProperty.customizedProperty);
		deleteQuery.where(QCustomizedProperty.customizedProperty.name.eq(name)).execute();
	}
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public void delete(Long id) {
		JPADeleteClause deleteQuery = JPAQueryHolder.createDeleteQuery(QCustomizedProperty.customizedProperty);
		deleteQuery.where(QCustomizedProperty.customizedProperty.id.eq(id)).execute();
	}
	
	@Override
	public CustomizedPropertyDTO findByName(String name) {
		final Optional<CustomizedProperty> cp = findEntityByName(name);
		return cp.map(c -> {
			CustomizedPropertyDTO customizedPropertyDTO = new CustomizedPropertyDTO();
			customizedPropertyDTO.setName(c.getName());
			customizedPropertyDTO.setType(c.getType());
			return customizedPropertyDTO;
		}).orElse(null);
	}
	
	@Override
	public Optional<CustomizedProperty> findEntityByName(String name) {
		final EqualsSpecification<CustomizedProperty> customizedPropertyEqualsSpecification = new EqualsSpecification<>(
				"name", name);
		return customizedPropertyRepository.findOne(customizedPropertyEqualsSpecification);
	}
}