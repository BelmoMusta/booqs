package com.musta.belmo.booqs.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	private String resourceName;
	private Long id;
	
	public NotFoundException() {
		super();
	}
	
	public NotFoundException(String resourceName, Long id) {
		super();
		this.resourceName = resourceName;
		this.id = id;
		
	}
	
	@Override
	public String getMessage() {
		String previousMessage = "";
		if (StringUtils.isNotBlank(super.getMessage())) {
			previousMessage = ", Previous message : " + super.getMessage();
		}
		return String.format("The resource '%s' with the id '%s' is not found%s", resourceName, id, previousMessage);
	}
}
