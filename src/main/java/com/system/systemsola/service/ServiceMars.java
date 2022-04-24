package com.system.systemsola.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.system.systemsola.Exceptions.ReturnErroFindSearchNotFound;
import com.system.systemsola.dto.MarsDTO;
import com.system.systemsola.model.Mars;
import com.system.systemsola.model.Mercury;
import com.system.systemsola.repository.RepositoryMars;

@Service
public class ServiceMars {
  
	private RepositoryMars repository;
 	private ModelMapper mapper;
 	
	public ServiceMars(RepositoryMars repository, ModelMapper mapper) {
 		this.repository = repository;
		this.mapper = mapper;
	}
 
	public ResponseEntity<MarsDTO> saveBody(MarsDTO MarsDto) {
		ValidValueDuplicate(MarsDto);
		Mars body = bodySave(mapper.map(MarsDto, Mars.class));
		return ResponseEntity
				  .status(HttpStatus.OK)
				  .body(mapper.map(body, MarsDTO.class));
	}

	private Mars bodySave(Mars mars) {
 		return repository.save(mars);
	}
	
	public void ValidValueDuplicate(MarsDTO MarsDto) {
		Mercury dtoPlane = mapper.map(MarsDto, Mercury.class);
		Mercury systemFind = repository.findByName(MarsDto.getName());
		if(systemFind != null && systemFind.getId() != dtoPlane.getId()) {
			throw new ReturnErroFindSearchNotFound("Planeta "+ systemFind.getName()+" Já esta cadastrado");
		}
	}
	
	public ResponseEntity<MarsDTO> listId(Long id) {
		Optional<Mars> idPla = repository.findById(id);
		if(idPla.isPresent()) {
			return ResponseEntity.ok(mapper.map(idPla.get(), MarsDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	public ResponseEntity<MarsDTO> update(Long id, MarsDTO MarsDto) {
		Optional<Mars> dataMercu = repository.findById(id);
		if(dataMercu.isPresent()) {
			Mars dataMer = dataMercu.get();
			dataMer.setName(MarsDto.getName());
			dataMer.setDistanceSun(MarsDto.getDistanceSun());
			dataMer.setSurfaceArea(MarsDto.getSurfaceArea());
			dataMer.setGravity(MarsDto.getGravity());
			dataMer.setRadius(MarsDto.getRadius());
			dataMer.setOrbitalPeriod(MarsDto.getOrbitalPeriod());
			dataMer.setMoons(MarsDto.getMoons());
			dataMer.setQtmoons(MarsDto.getQtmoons());
			dataMer.setTemMedia(MarsDto.getTemMedia());
			dataMer.setTemMaxima(MarsDto.getTemMaxima());
			dataMer.setTemMinima(MarsDto.getTemMinima());
			repository.save(dataMer);
			return ResponseEntity.ok(mapper.map(dataMer, MarsDTO.class));
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		}
	}
	
	
	public ResponseEntity<MarsDTO> delete(Long id) {
		Optional<Mars> findId = repository.findById(id);
		if(findId.isPresent()) {
			repository.delete(findId.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
}























