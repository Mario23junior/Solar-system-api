package com.system.systemsola.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.systemsola.dto.SaturnDTO;
import com.system.systemsola.service.ServiceSaturn;

@RestController
@RequestMapping("/api/v1/planetary/saturn/")
public class ControllerSaturn {

	private ServiceSaturn service;

	public ControllerSaturn(ServiceSaturn service) {
	 		this.service = service;
		}

	@PostMapping
	public ResponseEntity<SaturnDTO> save(@RequestBody SaturnDTO saturnDTO) {
		return service.saveBody(saturnDTO);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<SaturnDTO> update(@PathVariable Long id,@RequestBody SaturnDTO saturnDto){
		return service.update(id, saturnDto);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<SaturnDTO> delete(@PathVariable Long id){
		return service.listId(id);
	}
}
