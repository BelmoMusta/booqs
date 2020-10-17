package com.musta.belmo.booqs.controller.author;

import com.musta.belmo.booqs.controller.BaseController;
import com.musta.belmo.booqs.service.AuthorService;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class AuthorBaseController extends BaseController {
	@Autowired
	protected AuthorService authorService;
	
	@Override
	@Bean("AuthorOpenApiDefinition")
	public GroupedOpenApi createGroupedOpenApiAsBean() {
		return createGroupedOpenApi("Author");
	}
}
