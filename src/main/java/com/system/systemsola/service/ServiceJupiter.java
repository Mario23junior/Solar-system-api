package com.system.systemsola.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.system.systemsola.Exceptions.ReturnErroFindSearchNotFound;
import com.system.systemsola.dto.JupiterDTO;
import com.system.systemsola.model.Jupiter;
import com.system.systemsola.repository.RepositoryJupiter;

@Service
public class ServiceJupiter {
  
	private RepositoryJupiter repository;
 	private ModelMapper mapper;
 	
	public ServiceJupiter(RepositoryJupiter repository, ModelMapper mapper) {
 		this.repository = repository;
		this.mapper = mapper;
	}
 
	public ResponseEntity<JupiterDTO> saveBody(JupiterDTO jupiterDto) {
		ValidValueDuplicate(jupiterDto);
		Jupiter body = bodySave(mapper.map(jupiterDto, Jupiter.class));
		return ResponseEntity
				  .status(HttpStatus.OK)
				  .body(mapper.map(body, JupiterDTO.class));
	}

	private Jupiter bodySave(Jupiter jupiter) {
 		return repository.save(jupiter);
	}
	
	public void ValidValueDuplicate(JupiterDTO jupiterDto) {
		Jupiter dtoPlane = mapper.map(jupiterDto, Jupiter.class);
		Jupiter systemFind = repository.findByName(jupiterDto.getName());
		if(systemFind != null && systemFind.getId() != dtoPlane.getId()) {
			throw new ReturnErroFindSearchNotFound("Planeta "+ systemFind.getName()+" Já esta cadastrado");
		}
	}
	
	
	public ResponseEntity<JupiterDTO> listId(Long id) {
		Optional<Jupiter> idPla = repository.findById(id);
		if(idPla.isPresent()) {
			return ResponseEntity.ok(mapper.map(idPla.get(), JupiterDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	public ResponseEntity<JupiterDTO> update(Long id, JupiterDTO jupiterDto) {
		Optional<Jupiter> dataMercu = repository.findById(id);
		if(dataMercu.isPresent()) {
			Jupiter dataMer = dataMercu.get();
			dataMer.setName(jupiterDto.getName());
			dataMer.setDistanceSun(jupiterDto.getDistanceSun());
			dataMer.setSurfaceArea(jupiterDto.getSurfaceArea());
			dataMer.setGravity(jupiterDto.getGravity());
			dataMer.setRadius(jupiterDto.getRadius());
			dataMer.setOrbitalPeriod(jupiterDto.getOrbitalPeriod());
			dataMer.setMoons(jupiterDto.getMoons());
			dataMer.setQtmoons(jupiterDto.getQtmoons());
			dataMer.setTemMedia(jupiterDto.getTemMedia());
			dataMer.setTemMaxima(jupiterDto.getTemMaxima());
			dataMer.setTemMinima(jupiterDto.getTemMinima());
			repository.save(dataMer);
			return ResponseEntity.ok(mapper.map(dataMer, JupiterDTO.class));
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		}
	}
	
	public ResponseEntity<JupiterDTO> delete(Long id) {
		Optional<Jupiter> findId = repository.findById(id);
		if(findId.isPresent()) {
			repository.delete(findId.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
}
