package com.system.systemsola.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.system.systemsola.Exceptions.ReturnErroFindSearchNotFound;
import com.system.systemsola.dto.VenusDTO;
import com.system.systemsola.model.Saturn;
import com.system.systemsola.model.Venus;
import com.system.systemsola.repository.RepositoryVenus;

@Service
public class ServiceVenus {
   
	private RepositoryVenus repository;
	private ModelMapper mapper;

	public ServiceVenus(RepositoryVenus repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public ResponseEntity<VenusDTO> saveBody(VenusDTO venusDto) {
		ValidValueDuplicate(venusDto);
		Venus body = bodySave(mapper.map(venusDto, Venus.class));
		return ResponseEntity
				  .status(HttpStatus.OK)
				  .body(mapper.map(body, VenusDTO.class));
	}

	private Venus bodySave(Venus venus) {
 		return repository.save(venus);
	}
	
	public void ValidValueDuplicate(VenusDTO venusDto) {
		Saturn dtoPlane = mapper.map(venusDto, Saturn.class);
		Venus systemFind = repository.findByName(venusDto.getName());
		if(systemFind != null && systemFind.getId() != dtoPlane.getId()) {
			throw new ReturnErroFindSearchNotFound("Planeta "+ systemFind.getName()+" Já esta cadastrada");
		}
	}
}
