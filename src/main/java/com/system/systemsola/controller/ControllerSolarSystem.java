package com.system.systemsola.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.systemsola.dto.SystemSolarDTO;
import com.system.systemsola.service.ServiceSolarSystem;

@RestController
@RequestMapping("/api/v1/planetary/systemsolar/")
public class ControllerSolarSystem {

	private ServiceSolarSystem service;

	public ControllerSolarSystem(ServiceSolarSystem service) {
		super();
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<SystemSolarDTO> save(@RequestBody SystemSolarDTO systemSolarDto) {
		return service.saveBody(systemSolarDto);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<SystemSolarDTO> listId(@PathVariable Long id) {
		return service.listId(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<SystemSolarDTO> update(@PathVariable Long id, @RequestBody SystemSolarDTO systemSolarDTO) {
		return service.update(id, systemSolarDTO);
	}
}
