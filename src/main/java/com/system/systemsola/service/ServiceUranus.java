package com.system.systemsola.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.system.systemsola.Exceptions.ReturnErroFindSearchNotFound;
import com.system.systemsola.dto.UranosDTO;
import com.system.systemsola.model.Mercury;
import com.system.systemsola.model.Uranos;
import com.system.systemsola.repository.RepositoryUranus;

@Service
public class ServiceUranus {
  
	private RepositoryUranus repository;
	private ModelMapper mapper;

	public ServiceUranus(ModelMapper mapper,RepositoryUranus repository) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public ResponseEntity<UranosDTO> saveBody(UranosDTO uranosDto) {
		ValidValueDuplicate(uranosDto);
		Uranos body = bodySave(mapper.map(uranosDto, Uranos.class));
		return ResponseEntity
				  .status(HttpStatus.OK)
				  .body(mapper.map(body, UranosDTO.class));
	}

	private Uranos bodySave(Uranos uranos) {
 		return repository.save(uranos);
	}
	
	public void ValidValueDuplicate(UranosDTO uranosDto) {
		Mercury dtoPlane = mapper.map(uranosDto, Mercury.class);
		Uranos systemFind = repository.findByName(uranosDto.getName());
		if(systemFind != null && systemFind.getId() != dtoPlane.getId()) {
			throw new ReturnErroFindSearchNotFound("Planeta "+ systemFind.getName()+" Já esta cadastrado");
		}
	}
	
	public ResponseEntity<UranosDTO> listId(Long id) {
		Optional<Uranos> idPla = repository.findById(id);
		if(idPla.isPresent()) {
			return ResponseEntity.ok(mapper.map(idPla.get(), UranosDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
}
