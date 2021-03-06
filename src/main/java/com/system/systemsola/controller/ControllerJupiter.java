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

import com.system.systemsola.dto.JupiterDTO;
import com.system.systemsola.service.ServiceJupiter;

@RestController
@RequestMapping("/api/v1/planetary/jupiter/")
public class ControllerJupiter {

	private ServiceJupiter service;

	public ControllerJupiter(ServiceJupiter service) {
	 		this.service = service;
		}

	@PostMapping
	public ResponseEntity<JupiterDTO> save(@RequestBody JupiterDTO jupiterDto) {
		return service.saveBody(jupiterDto);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<JupiterDTO> list(@PathVariable Long id) {
		return service.listId(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<JupiterDTO> update(@PathVariable Long id,@RequestBody JupiterDTO jupiterDto) {
		return service.update(id, jupiterDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<JupiterDTO> delete(@PathVariable Long id) {
		return service.delete(id);
	}

}
