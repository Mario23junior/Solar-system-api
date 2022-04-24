package com.system.systemsola.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.system.systemsola.Exceptions.ReturnErroFindSearchNotFound;
import com.system.systemsola.dto.SystemSolarDTO;
import com.system.systemsola.model.SystemSolar;
import com.system.systemsola.repository.RepositorySystemSolar;

@Service
public class ServiceSolarSystem {

 	private RepositorySystemSolar repoSystemSol;
	
 	private ModelMapper mapper;
	
	public ServiceSolarSystem(RepositorySystemSolar repoSystemSol, ModelMapper mapper) {
 		this.repoSystemSol = repoSystemSol;
		this.mapper = mapper;
	}

	public ResponseEntity<SystemSolarDTO> saveBody(SystemSolarDTO solaSystemDto) {
		ValidValueDuplicate(solaSystemDto);
		SystemSolar body = bodySave(mapper.map(solaSystemDto, SystemSolar.class));
		return ResponseEntity
				  .status(HttpStatus.OK)
				  .body(mapper.map(body, SystemSolarDTO.class));
	}

	private SystemSolar bodySave(SystemSolar systemSolar) {
 		return repoSystemSol.save(systemSolar);
	}
	
	public void ValidValueDuplicate(SystemSolarDTO solaSystemDto) {
		SystemSolar dtoPlane = mapper.map(solaSystemDto, SystemSolar.class);
		SystemSolar systemFind = repoSystemSol.findByName(solaSystemDto.getName());
		if(systemFind != null && systemFind.getId() != dtoPlane.getId()) {
			throw new ReturnErroFindSearchNotFound("Informação "+ systemFind.getName()+" Já esta cadastrada");
		}
	}
	
	public ResponseEntity<SystemSolar> listId(Long id) {
		Optional<SystemSolar> idPla = repoSystemSol.findById(id);
		if(idPla.isPresent()) {
			return ResponseEntity.ok(mapper.map(idPla.get(), SystemSolar.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
}
