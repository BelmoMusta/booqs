package com.musta.belmo.booqs.service.impl;

import com.musta.belmo.booqs.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService {
	@Autowired
	protected EntityMapper entityMapper;
	
}
