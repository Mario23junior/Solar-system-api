package com.system.systemsola.service;

import java.util.Optional;

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
	
	
	public ResponseEntity<NeptuneDTO> listId(Long id) {
		Optional<Neptune> idPla = repository.findById(id);
		if(idPla.isPresent()) {
			return ResponseEntity.ok(mapper.map(idPla.get(), NeptuneDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	

	public ResponseEntity<NeptuneDTO> update(Long id, NeptuneDTO neptuneDTO) {
		Optional<Neptune> dataMercu = repository.findById(id);
		if(dataMercu.isPresent()) {
			Neptune dataMer = dataMercu.get();
			dataMer.setName(neptuneDTO.getName());
			dataMer.setDistanceSun(neptuneDTO.getDistanceSun());
			dataMer.setSurfaceArea(neptuneDTO.getSurfaceArea());
			dataMer.setGravity(neptuneDTO.getGravity());
			dataMer.setRadius(neptuneDTO.getRadius());
			dataMer.setOrbitalPeriod(neptuneDTO.getOrbitalPeriod());
			dataMer.setMoons(neptuneDTO.getMoons());
			dataMer.setQtmoons(neptuneDTO.getQtmoons());
			dataMer.setTemMedia(neptuneDTO.getTemMedia());
			dataMer.setTemMaxima(neptuneDTO.getTemMaxima());
			dataMer.setTemMinima(neptuneDTO.getTemMinima());
			repository.save(dataMer);
			return ResponseEntity.ok(mapper.map(dataMer, NeptuneDTO.class));
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		}
	}
	
	
 
	
	

}
