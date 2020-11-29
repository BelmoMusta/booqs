package com.musta.belmo.booqs.service;


import com.musta.belmo.booqs.entite.CustomizedValue;
import com.musta.belmo.booqs.entite.dto.CustomizedValueDTO;

import java.util.List;

public interface CustomizedValueService {
	void create(CustomizedValueDTO propertyDTO);
	
	void delete(String name);
	
	void delete(Long name);
	
	CustomizedValueDTO findByName(String name);
	
	List<CustomizedValueDTO> findFor(String tableName, Long id);
	
	CustomizedValue findFor(String valueName, String tableName, Long id);
	
	void createFor(Long id, String user, CustomizedValueDTO customizedValueDTO);
}
