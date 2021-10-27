package com.user.service.exceptions;

public class ValidationError {
	
	private String filedName;
	
	private String errorMessage;
	
	public ValidationError(String filedName, String errorMessage) {
		super();
		this.filedName = filedName;
		this.errorMessage = errorMessage;
	}

	public String getFiledName() {
		return filedName;
	}

	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
