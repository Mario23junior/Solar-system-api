package com.system.systemsola.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.system.systemsola.Exceptions.ReturnErroFindSearchNotFound;
import com.system.systemsola.dto.SaturnDTO;
import com.system.systemsola.model.Saturn;
import com.system.systemsola.repository.RepositorySaturn;

@Service
public class ServiceSaturn {
  
	private RepositorySaturn repository;
	private ModelMapper mapper;

	public ServiceSaturn(RepositorySaturn repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public ResponseEntity<SaturnDTO> saveBody(SaturnDTO saturnDTO) {
		ValidValueDuplicate(saturnDTO);
		Saturn body = bodySave(mapper.map(saturnDTO, Saturn.class));
		return ResponseEntity
				  .status(HttpStatus.OK)
				  .body(mapper.map(body, SaturnDTO.class));
	}

	private Saturn bodySave(Saturn saturn) {
 		return repository.save(saturn);
	}
	
	public void ValidValueDuplicate(SaturnDTO saturnDto) {
		Saturn dtoPlane = mapper.map(saturnDto, Saturn.class);
		Saturn systemFind = repository.findByName(saturnDto.getName());
		if(systemFind != null && systemFind.getId() != dtoPlane.getId()) {
			throw new ReturnErroFindSearchNotFound("Planeta "+ systemFind.getName()+" Já esta cadastrada");
		}
	}
	
}
