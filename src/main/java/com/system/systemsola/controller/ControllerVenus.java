package com.system.systemsola.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.systemsola.dto.VenusDTO;
import com.system.systemsola.service.ServiceVenus;

@RestController
@RequestMapping("/api/v1/planetary/venus/")
public class ControllerVenus {
  
	private ServiceVenus service;

	public ControllerVenus(ServiceVenus service) {
 		this.service = service;
	}

	@PostMapping
	public ResponseEntity<VenusDTO> save(@RequestBody VenusDTO venusDto) {
		return service.saveBody(venusDto);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<VenusDTO> list(@PathVariable Long id) {
		return service.listId(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<VenusDTO> list(@PathVariable Long id,@RequestBody VenusDTO venusDto) {
		return service.update(id, venusDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<VenusDTO> delete(@PathVariable Long id) {
		return service.delete(id);
	}
	
	
	
}
