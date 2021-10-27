package com.user.service.exceptions;

import java.util.List;

public class ErrorResponse {
	
	private List<ValidationError> errors;

	public ErrorResponse(List<ValidationError> errors) {
		this.errors = errors;
	}

	public List<ValidationError> getErrors() {
		return errors;
	}

	public void setErrors(List<ValidationError> errors) {
		this.errors = errors;
	}
	
}
