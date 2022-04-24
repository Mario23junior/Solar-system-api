package com.system.systemsola.modelErro;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class modelErroCustom {
  
	private Integer status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date timestamp;
	private String message;
	private String path;
	
	public modelErroCustom(Integer status, Date timestamp, String message, String path) {
 		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
		this.path = path;
	}
 

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
