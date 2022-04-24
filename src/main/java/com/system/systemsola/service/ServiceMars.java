package com.system.systemsola.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.system.systemsola.Exceptions.ReturnErroFindSearchNotFound;
import com.system.systemsola.dto.MarsDTO;
import com.system.systemsola.model.Mars;
import com.system.systemsola.model.Mercury;
import com.system.systemsola.repository.RepositoryMars;

@Service
public class ServiceMars {
  
	private RepositoryMars repository;
 	private ModelMapper mapper;
 	
	public ServiceMars(RepositoryMars repository, ModelMapper mapper) {
 		this.repository = repository;
		this.mapper = mapper;
	}
 
	public ResponseEntity<MarsDTO> saveBody(MarsDTO MarsDto) {
		ValidValueDuplicate(MarsDto);
		Mars body = bodySave(mapper.map(MarsDto, Mars.class));
		return ResponseEntity
				  .status(HttpStatus.OK)
				  .body(mapper.map(body, MarsDTO.class));
	}

	private Mars bodySave(Mars mars) {
 		return repository.save(mars);
	}
	
	public void ValidValueDuplicate(MarsDTO MarsDto) {
		Mercury dtoPlane = mapper.map(MarsDto, Mercury.class);
		Mercury systemFind = repository.findByName(MarsDto.getName());
		if(systemFind != null && systemFind.getId() != dtoPlane.getId()) {
			throw new ReturnErroFindSearchNotFound("Planeta "+ systemFind.getName()+" Já esta cadastrado");
		}
	}
	
	
}
