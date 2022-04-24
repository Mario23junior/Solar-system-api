package com.system.systemsola.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.system.systemsola.Exceptions.ReturnErroFindSearchNotFound;
import com.system.systemsola.dto.JupiterDTO;
import com.system.systemsola.model.Jupiter;
import com.system.systemsola.repository.RepositoryJupiter;

@Service
public class ServiceJupiter {
  
	private RepositoryJupiter repository;
 	private ModelMapper mapper;
 	
	public ServiceJupiter(RepositoryJupiter repository, ModelMapper mapper) {
 		this.repository = repository;
		this.mapper = mapper;
	}
 
	public ResponseEntity<JupiterDTO> saveBody(JupiterDTO jupiterDto) {
		ValidValueDuplicate(jupiterDto);
		Jupiter body = bodySave(mapper.map(jupiterDto, Jupiter.class));
		return ResponseEntity
				  .status(HttpStatus.OK)
				  .body(mapper.map(body, JupiterDTO.class));
	}

	private Jupiter bodySave(Jupiter jupiter) {
 		return repository.save(jupiter);
	}
	
	public void ValidValueDuplicate(JupiterDTO jupiterDto) {
		Jupiter dtoPlane = mapper.map(jupiterDto, Jupiter.class);
		Jupiter systemFind = repository.findByName(jupiterDto.getName());
		if(systemFind != null && systemFind.getId() != dtoPlane.getId()) {
			throw new ReturnErroFindSearchNotFound("Planeta "+ systemFind.getName()+" Já esta cadastrado");
		}
	}
	
}
