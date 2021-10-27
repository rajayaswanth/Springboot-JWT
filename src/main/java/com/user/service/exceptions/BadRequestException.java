package com.user.service.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1489724686900949326L;
	
	private List<ValidationError> validateErrors;

	public BadRequestException(String exception, List<ValidationError> validateErrors) {
		super(exception);
		this.validateErrors = validateErrors;
	}

	public List<ValidationError> getValidateErrors() {
		return validateErrors;
	}

	public void setValidateErrors(List<ValidationError> validateErrors) {
		this.validateErrors = validateErrors;
	}
	
}
