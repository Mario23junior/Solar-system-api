package com.system.systemsola.modelErro;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.system.systemsola.Exceptions.ReturnErroFindSearchNotFound;

@RestControllerAdvice
public class ControllerAdviceCustom {
  
	@ExceptionHandler(ReturnErroFindSearchNotFound.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public modelErroCustom returnErroCustom(ReturnErroFindSearchNotFound ex, WebRequest request) {
		modelErroCustom erro = new modelErroCustom(
				HttpStatus.NOT_FOUND.value(),
				new Date(),
				ex.getMessage(), 
				request.getDescription(false));
		
		return erro;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public modelErroCustom globalErro(Exception ex, WebRequest request) {
		modelErroCustom statusErroGlobal = new modelErroCustom(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				new Date(),
				ex.getMessage(), 
				request.getDescription(false));
		
		return statusErroGlobal;
	}
	
}
