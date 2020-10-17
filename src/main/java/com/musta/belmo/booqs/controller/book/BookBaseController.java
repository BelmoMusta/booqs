package com.musta.belmo.booqs.controller.book;

import com.musta.belmo.booqs.controller.BaseController;
import com.musta.belmo.booqs.service.BookService;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class BookBaseController extends BaseController {
	@Autowired
	protected BookService bookService;
	
	@Override
	@Bean("BookOpenApiDefinition")
	public GroupedOpenApi createGroupedOpenApiAsBean() {
		return createGroupedOpenApi("Book");
	}
}
