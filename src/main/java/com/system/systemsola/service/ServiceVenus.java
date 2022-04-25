package com.system.systemsola.service;

import java.util.Optional;

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
	
	
	public ResponseEntity<VenusDTO> listId(Long id) {
		Optional<Venus> idPla = repository.findById(id);
		if(idPla.isPresent()) {
			return ResponseEntity.ok(mapper.map(idPla.get(), VenusDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	public ResponseEntity<VenusDTO> update(Long id, VenusDTO venusDto) {
		Optional<Venus> dataMercu = repository.findById(id);
		if(dataMercu.isPresent()) {
			Venus dataMer = dataMercu.get();
			dataMer.setName(venusDto.getName());
			dataMer.setDistanceSun(venusDto.getDistanceSun());
			dataMer.setSurfaceArea(venusDto.getSurfaceArea());
			dataMer.setGravity(venusDto.getGravity());
			dataMer.setRadius(venusDto.getRadius());
			dataMer.setOrbitalPeriod(venusDto.getOrbitalPeriod());
			dataMer.setMoons(venusDto.getMoons());
			dataMer.setQtmoons(venusDto.getQtmoons());
			dataMer.setTemMedia(venusDto.getTemMedia());
			dataMer.setTemMaxima(venusDto.getTemMaxima());
			dataMer.setTemMinima(venusDto.getTemMinima());
			repository.save(dataMer);
			return ResponseEntity.ok(mapper.map(dataMer, VenusDTO.class));
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		}
	}
	
	public ResponseEntity<VenusDTO> delete(Long id) {
		Optional<Venus> findId = repository.findById(id);
		if(findId.isPresent()) {
			repository.delete(findId.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
}
