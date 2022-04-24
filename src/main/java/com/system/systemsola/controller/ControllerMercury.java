package com.system.systemsola.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.systemsola.dto.MercuryDTO;
import com.system.systemsola.service.ServiceMercury;

@RestController
@RequestMapping("/api/v1/planetary/mercury/")
public class ControllerMercury {
 
	private ServiceMercury service;

	public ControllerMercury(ServiceMercury service) {
 		this.service = service;
	}

	@PostMapping
	public ResponseEntity<MercuryDTO> save(@RequestBody MercuryDTO mercuryDTO) {
		return service.saveBody(mercuryDTO);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<MercuryDTO> listId(@PathVariable Long id) {
		return service.listId(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<MercuryDTO> update(@PathVariable Long id, @RequestBody MercuryDTO mercuryDto){
		return service.update(id, mercuryDto);
	}
	
}
