package com.tulesh.springboot.DTO.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> {
	private String status = "success";
	private String message;
	private T data;
	
	//For pagination
	private int currentPage;
	private int totalPages;
	private int pageSize;
	private long totalRecords;
	private Date lastUpdatedTime = new Date();
	public ResponseDTO(T data) {
		super();
		this.data = data;
	}
	public ResponseDTO(String msg, T data) {
		super();
		this.message = msg;
		this.data = data;
	}
	public ResponseDTO(String status, String msg) {
		super();
		this.status = status;
		this.message = msg;
	}
	
	public ResponseDTO(String status, String msg, T data) {
		super();
		this.status = status;
		this.message = msg;
		this.data = data;
	}
	
	public ResponseDTO(String msg, T data, long totalRecords) {
		super();
		this.message = msg;
		this.data = data;
		this.totalRecords = totalRecords;
	}
}
