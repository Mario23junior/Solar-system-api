package com.system.systemsola.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
		//ValueBeDuplicate(solaSystemDto);
		SystemSolar body = bodySave(mapper.map(solaSystemDto, SystemSolar.class));
		return ResponseEntity
				  .status(HttpStatus.OK)
				  .body(mapper.map(body, SystemSolarDTO.class));
	}

	private SystemSolar bodySave(SystemSolar systemSolar) {
 		return repoSystemSol.save(systemSolar);
	}
}
