package com.user.service.exceptions;

import java.util.List;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -9149725797668270351L;
	
	private List<ValidationError> validateErrors;

	public NotFoundException(String exception, List<ValidationError> validateErrors) {
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
