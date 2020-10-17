package com.musta.belmo.booqs.controller;

import org.springdoc.core.GroupedOpenApi;

public abstract class BaseController extends ReponseController {
	
	@SuppressWarnings("unused")
	public abstract GroupedOpenApi createGroupedOpenApiAsBean();
	
	protected GroupedOpenApi createGroupedOpenApi(String groupName) {
		return GroupedOpenApi.builder()
				.setGroup(groupName)
				.packagesToScan(getClass().getPackage().getName())
				.build();
	}
}
