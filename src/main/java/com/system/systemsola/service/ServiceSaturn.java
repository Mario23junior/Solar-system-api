package com.system.systemsola.service;

import java.util.Optional;

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
	
	public ResponseEntity<SaturnDTO> listId(Long id) {
		Optional<Saturn> idPla = repository.findById(id);
		if(idPla.isPresent()) {
			return ResponseEntity.ok(mapper.map(idPla.get(), SaturnDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	

	public ResponseEntity<SaturnDTO> update(Long id, SaturnDTO saturnDTO) {
		Optional<Saturn> dataMercu = repository.findById(id);
		if(dataMercu.isPresent()) {
			Saturn dataMer = dataMercu.get();
			dataMer.setName(saturnDTO.getName());
			dataMer.setDistanceSun(saturnDTO.getDistanceSun());
			dataMer.setSurfaceArea(saturnDTO.getSurfaceArea());
			dataMer.setGravity(saturnDTO.getGravity());
			dataMer.setRadius(saturnDTO.getRadius());
			dataMer.setOrbitalPeriod(saturnDTO.getOrbitalPeriod());
			dataMer.setMoons(saturnDTO.getMoons());
			dataMer.setQtmoons(saturnDTO.getQtmoons());
			dataMer.setTemMedia(saturnDTO.getTemMedia());
			dataMer.setTemMaxima(saturnDTO.getTemMaxima());
			dataMer.setTemMinima(saturnDTO.getTemMinima());
			repository.save(dataMer);
			return ResponseEntity.ok(mapper.map(dataMer, SaturnDTO.class));
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		}
	}
}
