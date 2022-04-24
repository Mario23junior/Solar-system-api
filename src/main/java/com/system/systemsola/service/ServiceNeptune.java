package com.system.systemsola.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.system.systemsola.Exceptions.ReturnErroFindSearchNotFound;
import com.system.systemsola.dto.NeptuneDTO;
import com.system.systemsola.model.Neptune;
import com.system.systemsola.repository.RepositoryNeptune;

@Service
public class ServiceNeptune {

	private RepositoryNeptune repository;
	private ModelMapper mapper;

	public ServiceNeptune(RepositoryNeptune repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public ResponseEntity<NeptuneDTO> saveBody(NeptuneDTO neptuneDto) {
		ValidValueDuplicate(neptuneDto);
		Neptune body = bodySave(mapper.map(neptuneDto, Neptune.class));
		return ResponseEntity
				  .status(HttpStatus.OK)
				  .body(mapper.map(body, NeptuneDTO.class));
	}

	private Neptune bodySave(Neptune neptune) {
 		return repository.save(neptune);
	}
	
	public void ValidValueDuplicate(NeptuneDTO neptuneDto) {
		Neptune dtoPlane = mapper.map(neptuneDto, Neptune.class);
		Neptune systemFind = repository.findByName(neptuneDto.getName());
		if(systemFind != null && systemFind.getId() != dtoPlane.getId()) {
			throw new ReturnErroFindSearchNotFound("Planeta "+ systemFind.getName()+" Já esta cadastrado");
		}
	}

}
