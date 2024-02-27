package com.tulesh.springboot.exception;

import lombok.Data;

@Data 
public class ExceptionResponse {
	private String status = "error";
	private String message;
	private String detail;

//	public ExceptionResponse(String status, String message, String detail) {
//		super();
//		this.status = status;
//		this.message = message;
//		this.detail = detail;
//	}
	public ExceptionResponse(String message, String detail) {
		super();
		this.message = message;
		this.detail = detail;
	}


}