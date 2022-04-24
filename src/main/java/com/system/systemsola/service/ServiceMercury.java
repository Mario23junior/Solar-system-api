package com.system.systemsola.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.system.systemsola.Exceptions.ReturnErroFindSearchNotFound;
import com.system.systemsola.dto.MercuryDTO;
import com.system.systemsola.model.Mercury;
import com.system.systemsola.repository.RepositoryMercury;

@Service
public class ServiceMercury {
  
private RepositoryMercury repository;
 	private ModelMapper mapper;
 	
	public ServiceMercury(RepositoryMercury repository, ModelMapper mapper) {
 		this.repository = repository;
		this.mapper = mapper;
	}
 
	public ResponseEntity<MercuryDTO> saveBody(MercuryDTO mercuryDto) {
		ValidValueDuplicate(mercuryDto);
		Mercury body = bodySave(mapper.map(mercuryDto, Mercury.class));
		return ResponseEntity
				  .status(HttpStatus.OK)
				  .body(mapper.map(body, MercuryDTO.class));
	}

	private Mercury bodySave(Mercury mercury) {
 		return repository.save(mercury);
	}
	
	public void ValidValueDuplicate(MercuryDTO mercuryDto) {
		Mercury dtoPlane = mapper.map(mercuryDto, Mercury.class);
		Mercury systemFind = repository.findByName(mercuryDto.getName());
		if(systemFind != null && systemFind.getId() != dtoPlane.getId()) {
			throw new ReturnErroFindSearchNotFound("Planeta "+ systemFind.getName()+" Já esta cadastrado");
		}
	}
	
	
	public ResponseEntity<MercuryDTO> listId(Long id) {
		Optional<Mercury> idPla = repository.findById(id);
		if(idPla.isPresent()) {
			return ResponseEntity.ok(mapper.map(idPla.get(), MercuryDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
