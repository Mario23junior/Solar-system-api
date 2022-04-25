package com.system.systemsola.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.system.systemsola.Exceptions.ReturnErroFindSearchNotFound;
import com.system.systemsola.dto.EarthDTO;
import com.system.systemsola.model.Earth;
import com.system.systemsola.repository.RepositoryEarth;

@Service
public class ServiceEarth {
  
	private RepositoryEarth repository;
	private ModelMapper mapper;
	
	public ServiceEarth(RepositoryEarth repository, ModelMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public ResponseEntity<EarthDTO> saveBody(EarthDTO earthDto) {
		ValidValueDuplicate(earthDto);
		Earth body = bodySave(mapper.map(earthDto, Earth.class));
		return ResponseEntity
				  .status(HttpStatus.OK)
				  .body(mapper.map(body, EarthDTO.class));
	}

	private Earth bodySave(Earth earth) {
 		return repository.save(earth);
	}
	
	public void ValidValueDuplicate(EarthDTO earthDto) {
		Earth dtoPlane = mapper.map(earthDto, Earth.class);
		Earth systemFind = repository.findByName(earthDto.getName());
		if(systemFind != null && systemFind.getId() != dtoPlane.getId()) {
			throw new ReturnErroFindSearchNotFound("Planeta "+ systemFind.getName()+" Já esta cadastrado");
		}
	}
	
	public ResponseEntity<EarthDTO> listId(Long id) {
		Optional<Earth> idPla = repository.findById(id);
		if(idPla.isPresent()) {
			return ResponseEntity.ok(mapper.map(idPla.get(), EarthDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
}
