package com.musta.belmo.booqs.service;

import com.musta.belmo.booqs.entite.CustomizedProperty;
import com.musta.belmo.booqs.entite.dto.CustomizedPropertyDTO;

import java.util.Optional;

public interface CustomizePropertyService {
	void create(CustomizedPropertyDTO propertyDTO);
	
	void delete(String name);
	
	void delete(Long name);
	
	CustomizedPropertyDTO findByName(String name);
	
	Optional<CustomizedProperty> findEntityByName(String name);
}
